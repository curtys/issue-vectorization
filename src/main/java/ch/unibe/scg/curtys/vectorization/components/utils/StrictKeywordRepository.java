package ch.unibe.scg.curtys.vectorization.components.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author curtys
 */
public class StrictKeywordRepository extends KeywordRepository {

	public StrictKeywordRepository(String... keywords) {
		super(keywords);
	}

	@Override public boolean hasMatchingKeyword(String text) {
		String patternString = "\\s\\b(" + StringUtils.join(getKeywords(), "|") + ")\\b(\\s|\\.|\\?|!)";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);

		return matcher.find();
	}
}
