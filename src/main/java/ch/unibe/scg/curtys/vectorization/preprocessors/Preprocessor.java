package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * @author curtys
 */
public interface Preprocessor {
	void preprocess(List<Issue> issues);
}
