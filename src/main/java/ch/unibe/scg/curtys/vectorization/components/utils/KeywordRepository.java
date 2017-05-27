package ch.unibe.scg.curtys.vectorization.components.utils;

import org.apache.commons.lang3.StringUtils;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scurty
 */
public class KeywordRepository {

	private List<String> keywords;
	private List<String> keywordsWithSynonyms;

	public KeywordRepository() {
		this.keywords = new ArrayList<>();
		this.keywordsWithSynonyms = new ArrayList<>();
	}

	public void add(String keyword) {
		keywords.add(keyword);
	}

	public void addAll(List<String> collection) {
		keywords.addAll(collection);
	}

	public boolean contains(String word) {
		return keywords.contains(word) || keywordsWithSynonyms.contains(word);
	}

	public boolean hasMatchingKeyword(String text) {
		String patternString = "\\b(" + StringUtils.join(keywords, "|") + ")\\b";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);

		return matcher.find();
	}

	public void addWithSynonym(String keyword)
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException("not implemented");
	}
}
