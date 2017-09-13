package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author curtys
 */
public class CodeSnippetElements extends VectorComponent {

	public CodeSnippetElements() {
		super(new CodeSnippetFilter());
	}

	private static class CodeSnippetFilter implements TextFilter {
		@Override public boolean filter(String text) {

			/* { followed by ; */
			Pattern pattern1 = Pattern.compile("(\\{)+.*(;)+", Pattern.DOTALL);
			/* value assignments */
			Pattern pattern2 = Pattern.compile("(\\p{Upper}[a-z]*)+\\s\\p{Lower}[a-z]*(\\p{Upper}[a-z]+)*\\s=\\s.*;");
			/* object instantiation */
			Pattern pattern3 = Pattern.compile("new\\s(\\p{Upper}[a-z]*)+\\(");

			Matcher m1 = pattern1.matcher(text);
			if (m1.find()) return true;
			Matcher m2 = pattern2.matcher(text);
			if (m2.find()) return true;
			Matcher m3 = pattern3.matcher(text);
			return m3.find();
		}
	}
}
