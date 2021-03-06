package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Removes all duplicate issues.
 * @author curtys
 */
public class DuplicateFilter extends ChainPreprocessor {

	@Override protected void execute(List<Issue> issues) {
		Set<Issue> distinctIssues = new LinkedHashSet<>(issues);
		issues.clear();
		issues.addAll(distinctIssues);
	}
}
