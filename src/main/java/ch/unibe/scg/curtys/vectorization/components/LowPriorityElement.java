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
		Pattern pattern = Pattern.compile("(minor|low|normal|P3|P4|P5)",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(priority);
		return matcher.find() ? TRUE_VAL : FALSE_VAL;
	}
}
