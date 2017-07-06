package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Sets the true label source of all issues.
 * @author curtys
 */
public class TrueLabelPreprocessor extends ChainPreprocessor {

	private final int trueLabelSource;

	public TrueLabelPreprocessor(int trueLabelSource) {
		this.trueLabelSource = trueLabelSource;
	}

	@Override
	protected void execute(List<Issue> issues) {
		issues.forEach(i -> i.setTrueLabel(
				(trueLabelSource == Issue.LABEL_SOURCE_CLASSIFIED) ? i.getIssuetypeClassified() : i.getIssuetypeTracker()
		));
	}
}
