package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.Arrays;
import java.util.List;

/**
 * Removes all issues with non-whitelisted labels. Uses the true label source of the issues.
 * Created by scurty on 01.06.17.
 */
public class TrueLabelFilter extends ChainPreprocessor {

	private final String[] whitelist;

	public TrueLabelFilter(String... labelsWhitelist) {
		this.whitelist = labelsWhitelist != null ? labelsWhitelist : new String[]{};
	}

	@Override protected void execute(List<Issue> issues) {
		issues.removeIf(i -> {
			for (String label : whitelist) {
				if (i.getTrueLabel().equals(label))
					return false;
			}
			return true;
		});
	}
}

