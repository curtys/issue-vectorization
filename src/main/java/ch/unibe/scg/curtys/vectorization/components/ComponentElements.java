package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import org.apache.commons.lang3.StringUtils;

/**
 * @author curtys
 */
public class ComponentElements extends VectorComponent {
	@Override public int value(Issue issue) {
		return StringUtils.isBlank(issue.getComponent()) ? FALSE_VAL : TRUE_VAL;
	}
}
