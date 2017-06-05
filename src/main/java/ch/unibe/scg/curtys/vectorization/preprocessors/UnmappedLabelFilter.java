package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.label.LabelMapper;

import java.util.List;

/**
 * Created by scurty on 15.03.17.
 */
public class UnmappedLabelFilter extends ChainPreprocessor {

	private LabelMapper labelMapper;

	public UnmappedLabelFilter(LabelMapper labelMapper) {
		this.labelMapper = labelMapper;
	}

	@Override
	protected void execute(List<Issue> issues) {
		issues.removeIf(i -> !labelMapper.has(i.getTrueLabel()));
	}
}
