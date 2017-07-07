package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;
import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author curtys
 */
public abstract class VectorComponent {

	protected final static int TRUE_VAL = 1;
	protected final static int FALSE_VAL = 0;

	protected ArrayList<TextFilter> filters;

	public VectorComponent(TextFilter...  filters) {
		this.filters = new ArrayList<>(Arrays.asList(filters));
	}
	public VectorComponent() {
		this.filters = new ArrayList<>();
	}

	public int value(Issue issue) {
		return matchesFilter(issue.textRepresentation()) ? TRUE_VAL : FALSE_VAL;
	}

	protected boolean matchesFilter(String text) {
		for (TextFilter filter : filters) {
			if (filter.filter(text)) return true;
		}
		return false;
	}
}
