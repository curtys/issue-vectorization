package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Created by scurty on 18.03.17.
 */
public interface Preprocessor {
	void preprocess(List<Issue> issues);
}
