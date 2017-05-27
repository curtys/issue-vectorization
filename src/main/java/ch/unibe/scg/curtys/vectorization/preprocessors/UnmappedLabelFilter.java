package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.Labels;
import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Created by scurty on 15.03.17.
 */
public class UnmappedLabelFilter extends ChainPreprocessor {

	@Override
	protected void execute(List<Issue> issues) {
		issues.removeIf(i -> !Labels.has(i.getTrueLabel()));
	}
}
