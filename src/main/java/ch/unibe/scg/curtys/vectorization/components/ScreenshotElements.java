package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

/**
 * Created by scurty
 */
public class ScreenshotElements extends VectorComponent {
	@Override public int value(Issue issue) {
		return issue.hasScreenshot() ? TRUE_VAL : FALSE_VAL;
	}
}
