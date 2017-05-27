package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scurty
 */
public class LinkElements extends VectorComponent {

	public LinkElements() {
		super(new HTTPSTextFilter(), new HTMLTextFilter());
	}

	private static class HTTPSTextFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("https?://([-\\w\\.]+)+(:\\d+)?(/([\\w/_\\.]*(\\?\\S+)?)?)?",
					Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
			Matcher m = pattern.matcher(text);

			return m.find();
		}
	}

	private static class HTMLTextFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile("\\.x?html",
					Pattern.CASE_INSENSITIVE);
			Matcher m = pattern.matcher(text);

			return m.find();
		}
	}
}
