package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

/**
 * @author curtys
 */
public class PatchElements extends VectorComponent {

	@Override
	public int value(Issue issue) {
		return issue.hasPatch() ? TRUE_VAL : FALSE_VAL;
	}

}
