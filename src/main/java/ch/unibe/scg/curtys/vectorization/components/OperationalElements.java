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
			Pattern pattern = Pattern.compile("\\b\\p{Lower}[a-z]*(\\p{Upper}[a-z]+)*\\s?\\(.*\\)");
			Matcher m = pattern.matcher(text);

			return m.find();
		}
	}
	private static class ClassNameFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("(\\p{Upper}[a-z]*)+");
			Matcher m = pattern.matcher(text);
			while(m.find()) {
				if(m.group(1).contains("Exception")) continue;
				return true;
			}
			return false;
		}
	}
}
