package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;
import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scurty
 */
public class ReproductionElements extends KeywordVectorComponent {

	public ReproductionElements(String... keywords) {
//		super(new TextFilter[]{new ReproductionStepsFilter()}, keywords);
		super(keywords);
	}

	@Override
	public int value(Issue issue) {
		if(matchesRepository(issue.textRepresentation())
				&& super.value(issue) == TRUE_VAL) return TRUE_VAL;
		return FALSE_VAL;
	}

	private static class ReproductionStepsFilter implements TextFilter {
		@Override public boolean filter(String text) {
			Pattern pattern = Pattern.compile(
					"([\\*\\-\\u2022\\u2023\\u25E6\\u2043\\u2219]\\s[A-z])|(\\d\\.\\s[A-z])",
					Pattern.CASE_INSENSITIVE);
			Matcher m = pattern.matcher(text);
			return m.find();
		}
	}
}
