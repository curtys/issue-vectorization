package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scurty
 */
public class ErrorElements extends KeywordVectorComponent {

	public ErrorElements(String... keywords) {
		super(new TextFilter[]{new StackTraceFilter(), new ExceptionClassFilter()}, keywords);
	}

	private static class StackTraceFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("^.+Exception[^\\n]++(\\s+at .++)+",
					Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
			Matcher m = pattern.matcher(text);

			return m.find();
		}
	}
	private static class ExceptionClassFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("\\p{Upper}[A-z]*Exception[\\p{Punct}\\p{Blank}]?$",
					Pattern.DOTALL | Pattern.MULTILINE);
			Matcher m = pattern.matcher(text);

			return m.find();
		}
	}
}
