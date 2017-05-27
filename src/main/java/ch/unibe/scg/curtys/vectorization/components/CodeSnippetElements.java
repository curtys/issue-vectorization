package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scurty
 */
public class CodeSnippetElements extends VectorComponent {

	public CodeSnippetElements() {
		super(new CodeSnippetFilter());
	}

	private static class CodeSnippetFilter implements TextFilter {
		@Override public boolean filter(String text) {

//			Pattern pattern = Pattern.compile(";");
			Pattern pattern1 = Pattern.compile("(\\{)+.*(;)+", Pattern.DOTALL);
			Pattern pattern2 = Pattern.compile("(\\p{Upper}[a-z]*)+\\s\\p{Lower}[a-z]*(\\p{Upper}[a-z]+)*\\s=\\s.*;");
			Matcher m1 = pattern1.matcher(text);
			Matcher m2 = pattern2.matcher(text);

			return m1.find() || m2.find();
		}
	}
}
