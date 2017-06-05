package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scurty
 */
public class OperationalElements extends VectorComponent {

	public OperationalElements() {
		super(new LogFilter(), new MethodNameFilter(), new ClassNameFilter());
	}

	private static class LogFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("([a-zA-Z0-9_\\.])\\.([a-zA-Z0-9_\\.])\\([a-zA-Z0-9_\\.]:([\\d])\\)");
			Matcher m = pattern.matcher(text);

			return m.find();
		}
	}
	private static class MethodNameFilter implements TextFilter {
		@Override public boolean filter(String text) {
			// will match camelCases
			Pattern pattern = Pattern.compile("\\b[a-z][a-z0-9]*[A-Z][A-Za-z0-9]*");
			Matcher m = pattern.matcher(text);
			if (m.find()) return true;
			pattern = Pattern.compile("\\b\\p{Lower}\\w*\\s?\\(\\)");
			m = pattern.matcher(text);
			if (m.find()) return true;
			pattern = Pattern.compile("\\b\\p{Lower}\\w*\\s?\\(\\p{Upper}\\w*\\s\\p{Lower}\\w*\\)");
			m = pattern.matcher(text);

			return m.find();
		}
	}
	private static class ClassNameFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("\\b[A-Z]([A-Z0-9]*[a-z][a-z0-9]*[A-Z]|[a-z0-9]*[A-Z][A-Z0-9]*[a-z])[A-Za-z0-9]*");
			Matcher m = pattern.matcher(text);
			while(m.find()) {
				if(m.group().contains("Exception")) continue;
				return true;
			}
			return false;
		}
	}
}
