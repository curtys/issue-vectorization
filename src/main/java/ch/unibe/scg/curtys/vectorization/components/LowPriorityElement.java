package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author curtys
 */
public class LowPriorityElement extends VectorComponent {

	@Override public int value(Issue issue) {
		String priority = issue.getPriority();
		if (StringUtils.isBlank(priority)) return FALSE_VAL;
		Pattern p1 = Pattern.compile("(trivial|minor|low|normal|P3|P4|P5)",
				Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(priority);
		Pattern p2 = Pattern.compile("(high|highest|major|P1|P2)", Pattern.CASE_INSENSITIVE);
		Matcher m2 = p2.matcher(priority);
		return m1.find() && !m2.find() ? TRUE_VAL : FALSE_VAL;
	}
}
