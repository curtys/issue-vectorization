package ch.unibe.scg.curtys.vectorization.preprocessors;

import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.List;

/**
 * Created by scurty on 24.04.17.
 */
public class ProjectFilter extends ChainPreprocessor {
	private final String[] projects;

	public ProjectFilter(String... projects) {
		this.projects = projects;
	}

	@Override
	protected void execute(List<Issue> issues) {
		issues.removeIf(this::blacklisted);
	}

	private boolean blacklisted(Issue i) {
		for (String project : projects) {
			if (i.getProject().equals(project)) return true;
		}
		return false;
	}
}
