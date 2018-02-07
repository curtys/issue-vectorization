package ch.unibe.scg.curtys.vectorization;

import ch.unibe.scg.curtys.vectorization.io.JsonIO;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.testutils.VectorArchive;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author curtys
 */
public class Evaluation {

	@Test
	public void evaluation() {

		for (int i = 0; i < 23; i++) {
			Map<String, Double> results = eval(i);
			System.out.println("Index " + i + "\n"
					+ "		Accuracy: " + results.get("accuracy") + "\n"
					+ "		Precision: " + results.get("precision") + "\n"
					+ "		Recall: " + results.get("recall"));
		}
	}

	private Map<String, Double> eval(int index) {
		final int[] match = { 0 };
		final int[] truePositives = { 0 };
		final int[] falsePositives = { 0 };
		final int[] falseNegatives = { 0 };
		VectorizationEngine engine = VectorizationEngine.builder()
				.useDefaults().build();

		VectorArchive.getArchive().forEach((k, v) -> {
			String filename = k.getProject()+"-"+k.getId()+"."+"json";
			Path p = Paths.get(Evaluation.class.getResource("/testdata/"+filename).getPath());
			Issue issue = null;
			try {
				issue = JsonIO.mapIssue(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int[] actual = engine.vectorize(issue).getElements();
			if (actual[index] == v[index]) match[0]++;
			if (actual[index] == 1 && actual[index] == v[index]) truePositives[0]++;
			else if (actual[index] > v[index]) falsePositives[0]++;
			else if (actual[index] < v[index]) falseNegatives[0]++;
		});

		Map<String, Double> results = new HashMap<>();
		double acc = (double) match[0] / (double) VectorArchive.getAll().size();
		double prec = (double) truePositives[0] / (truePositives[0]+falsePositives[0]);
		double recall = (double) truePositives[0] / (truePositives[0] + falseNegatives[0]);
		results.put("accuracy", acc);
		results.put("precision", prec);
		results.put("recall", recall);
		return results;
	}
}
