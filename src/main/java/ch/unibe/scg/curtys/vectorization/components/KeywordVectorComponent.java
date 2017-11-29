package ch.unibe.scg.curtys.vectorization.components;

import ch.unibe.scg.curtys.vectorization.components.utils.KeywordRepository;
import ch.unibe.scg.curtys.vectorization.components.utils.TextFilter;
import ch.unibe.scg.curtys.vectorization.issue.Issue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author curtys
 */
public class KeywordVectorComponent extends VectorComponent {

	private List<KeywordRepository> repositories = new ArrayList<>();

	public KeywordVectorComponent(String... keywords) {
		KeywordRepository repository = new KeywordRepository();
		repository.addAll(Arrays.asList(keywords));
		repositories.add(repository);
	}

	public KeywordVectorComponent(TextFilter[] filters, String... keywords) {
		super(filters);
		KeywordRepository repository = new KeywordRepository();
		repository.addAll(Arrays.asList(keywords));
		repositories.add(repository);
	}

	@Override
	public int value(Issue issue) {
		if(matchesRepository(issue.textRepresentation())
				|| super.value(issue) == TRUE_VAL) return TRUE_VAL;
		return FALSE_VAL;
	}

	protected boolean matchesRepository(String text) {
		return repositories.stream().anyMatch(repository -> repository.hasMatchingKeyword(text));
	}

	public void addRepository(KeywordRepository repository) {
		repositories.add(repository);
	}
}
