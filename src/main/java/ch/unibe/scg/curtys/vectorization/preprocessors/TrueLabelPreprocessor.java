package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Created by scurty on 15.03.17.
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
