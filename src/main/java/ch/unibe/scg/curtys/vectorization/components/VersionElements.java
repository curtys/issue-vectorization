package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author curtys
 */
public class VersionElements extends VectorComponent {
	@Override public int value(Issue issue) {
		String version = issue.getVersion();
		if (StringUtils.isBlank(version))
			return FALSE_VAL;
		// default value of some issue tracking systems
		Pattern p = Pattern.compile("(other|none)", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(version);
		if (m.find())
			return FALSE_VAL;
		return TRUE_VAL;
	}
}
