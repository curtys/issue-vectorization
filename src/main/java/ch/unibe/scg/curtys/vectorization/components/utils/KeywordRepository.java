package ch.unibe.scg.curtys.vectorization.components.utils;

import org.apache.commons.lang3.StringUtils;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author curtys
 */
public class KeywordRepository {

	private List<String> keywords = new ArrayList<>();
	private List<String> keywordsWithSynonyms = new ArrayList<>();

	public KeywordRepository() {}

	public KeywordRepository(String... keywords) {
		this.keywords.addAll(Arrays.asList(keywords));
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

	public List<String> getKeywords() {
		return keywords;
	}
}
