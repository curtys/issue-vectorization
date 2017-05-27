package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.KeywordRepository;
import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;
import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.Arrays;

/**
 * Created by scurty
 */
public class KeywordVectorComponent extends VectorComponent {

	private KeywordRepository repository;

	public KeywordVectorComponent(String... keywords) {
		repository = new KeywordRepository();
		repository.addAll(Arrays.asList(keywords));
	}

	public KeywordVectorComponent(TextFilter[] filters, String... keywords) {
		super(filters);
		repository = new KeywordRepository();
		repository.addAll(Arrays.asList(keywords));

	}

	@Override
	public int value(Issue issue) {
		if(matchesRepository(issue.textRepresentation())
				|| super.value(issue) == TRUE_VAL) return TRUE_VAL;
		return FALSE_VAL;
	}

	protected boolean matchesRepository(String text) {
		return repository.hasMatchingKeyword(text);
	}
}
