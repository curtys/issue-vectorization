package ch.unibe.scg.curtys.vectorization.io;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.issue.IssueDeserializationMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by scurty
 */
public class JsonIO {

	public static List<Issue> readJsons(URI path) throws IOException {
		List<Issue> issues = new ArrayList<>();
		Files.walk(Paths.get(path))
				.filter(Files::isRegularFile)
				.filter(p -> p.toString().endsWith(".json"))
				.distinct()
				.forEach(p -> {
							try {
								issues.add(mapIssue(p));
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
				);
		return issues;
	}

	public static <T extends IssueDeserializationMapping> List<Issue> readJsons(URI path, Class<T> mapping) throws IOException {
		List<Issue> issues = new ArrayList<>();
		Files.walk(Paths.get(path))
				.filter(Files::isRegularFile)
				.filter(p -> p.toString().endsWith(".json"))
				.distinct()
				.forEach(p -> {
							try {
								issues.add(mapIssue(p, mapping));
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
				);
		return issues;
	}

	public static Issue mapIssue(Path path) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(path.toFile(), Issue.class);
	}

	public static <T extends IssueDeserializationMapping> Issue mapIssue(Path path, Class<T> mapping) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(path.toFile(), mapping).toIssue();
	}

	public static void writeMapToJSON(Map<String, String> map, String path) {
		JSONObject json = new JSONObject(map);
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
			writer.write(json.toString(3));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeJSON(JSONObject json, String path) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
			writer.write(json.toString(3));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}