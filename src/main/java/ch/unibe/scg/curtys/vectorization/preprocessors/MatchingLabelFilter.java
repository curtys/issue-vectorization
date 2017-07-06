package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Removes all issues which have non-identical values as "classified issue type"
 * and "tracker issue type".
 * @author curtys
 */
public class MatchingLabelFilter extends ChainPreprocessor {

	@Override
	protected void execute(List<Issue> issues) {
		issues.removeIf(i -> !i.getIssuetypeClassified().equals(i.getIssuetypeTracker()));
	}
}
