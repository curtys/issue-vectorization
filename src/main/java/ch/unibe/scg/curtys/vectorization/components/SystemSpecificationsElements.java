package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.issue.Issue;
import org.apache.commons.lang3.StringUtils;

/**
 * @author curtys
 */
public class SystemSpecificationsElements extends KeywordVectorComponent {

	public SystemSpecificationsElements(String... keywords) {
		super(keywords);
	}

	@Override
	public int value(Issue issue) {
		String env = issue.getSystemspecification();
		if (env != null) {
			env = env.toLowerCase()
					.replace("operating system:", "")
					.replace("platform:", "")
					.replace("<br/>", "")
					.replace("\n", " ")
					.replace("other", "")
					.replace("all", "")
					.trim();
		}
		return !StringUtils.isBlank(env) || (super.value(issue) == TRUE_VAL) ? TRUE_VAL : FALSE_VAL;
	}

}
