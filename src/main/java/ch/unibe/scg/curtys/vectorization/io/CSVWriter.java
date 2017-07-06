package ch.unibe.scg.curtys.vectorization.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author curtys
 */
public class CSVWriter {

	private static final char SEPARATOR = ',';

	public static boolean writeArrayToFile(Path path, int... data) {
		String csvStr = arrayToCSV(data);
		return write(csvStr, path);
	}

	public static String arrayToCSV(int... data) {
		boolean first = true;
		StringBuilder builder = new StringBuilder();
		for(int i : data) {
			if (!first) builder.append(SEPARATOR);
			builder.append(i);
			first = false;
		}
		return builder.toString();
	}

	public static String arrayToCSV(String... data) {
		boolean first = true;
		StringBuilder builder = new StringBuilder();
		for(String str : data) {
			if (!first) builder.append(SEPARATOR);
			builder.append(str);
			first = false;
		}
		return builder.toString();
	}

	public static String listToCSV(List data) {
		boolean first = true;
		StringBuilder builder = new StringBuilder();
		for(Object d : data) {
			if (!first) builder.append(SEPARATOR);
			builder.append(d.toString());
			first = false;
		}
		return builder.toString();
	}

	public static boolean writeCSVToFile(String path, List<String> lines) {
		try {
			Files.write(Paths.get(path), lines);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static boolean write(String str, Path path) {
		try {
			Path parentDir = path.getParent();
			if (!Files.exists(parentDir))
				Files.createDirectories(parentDir);
			Files.write(path, str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
