package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by scurty on 23.04.17.
 */
public class VersionElements extends VectorComponent {
	@Override public int value(Issue issue) {
		return StringUtils.isBlank(issue.getVersion()) ? FALSE_VAL : TRUE_VAL;
	}
}
