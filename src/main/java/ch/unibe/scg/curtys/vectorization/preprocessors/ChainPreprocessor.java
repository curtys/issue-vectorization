package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Created by scurty on 15.03.17.
 */
public abstract class ChainPreprocessor implements Preprocessor {

	private Preprocessor next = null;

	public final void preprocess(List<Issue> issues) {
		execute(issues);
		if (next != null)
			next.preprocess(issues);
	}

	public final void addNext(Preprocessor preprocessor) {
		next = preprocessor;
	}

	protected abstract void execute(List<Issue> issues);

}
