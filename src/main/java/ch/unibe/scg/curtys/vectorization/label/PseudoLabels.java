package ch.unibe.scg.curtys.vectorization.label;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Set;

/**
 * @author curtys
 */
public class PseudoLabels implements LabelMapper {
	private final BiMap<String, Integer> labelMap;
	private final String pseudonym = "NOBUG";

	public PseudoLabels() {
		labelMap = HashBiMap.create();
		labelMap.put("BUG", 0);
		labelMap.put(pseudonym, 1);
	}

	@Override
	public boolean validateLabels(String... labels) {
		return true;
	}

	@Override
	public boolean has(String label) {
		return labelMap.containsKey(label);
	}

	@Override
	public int get(String label) {
		return (has(label)) ? labelMap.get(label) : labelMap.get(pseudonym);
	}

	@Override
	public String get(int classLabel) {
		return labelMap.inverse().get(classLabel);
	}

	@Override
	public int size() {
		return labelMap.size();
	}

	@Override
	public Set<String> getAll() {
		return labelMap.keySet();
	}
}
