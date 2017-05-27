package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

/**
 * Created by scurty
 */
public class SystemSpecificationsElements extends KeywordVectorComponent {

	public SystemSpecificationsElements(String... keywords) {
		super(keywords);
	}

	@Override
	public int value(Issue issue) {
		return issue.hasSystemspecification() || (super.value(issue) == TRUE_VAL) ? TRUE_VAL : FALSE_VAL;
	}

}
