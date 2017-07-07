package ch.unibe.scg.curtys.vectorization.label;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author curtys
 */
public class AbstractLabelMapper implements LabelMapper {
	protected BiMap<String, Integer> labelMap;
	private final Logger log = LoggerFactory.getLogger(AbstractLabelMapper.class);

	public AbstractLabelMapper(String... labelNames) {
		labelMap = HashBiMap.create();
		for (int i = 0; i < labelNames.length; i++) {
			labelMap.put(labelNames[i], i);
		}
	}

	@Override
	public boolean validateLabels(String... labels) {
		Set<String> checked = new HashSet<>();
		for (String label : labels) {
			if(!labelMap.containsKey(label)) {
				log.warn("Label " + label + " not registered");
				return false;
			}
			checked.add(label);
		}
		if (checked.size() != labelMap.size()) {
			for (String label :  labelMap.keySet()) {
				if (!checked.contains(label))
					log.warn("Label " + label + " is registered but does never occur!");
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean has(String label) {
		return labelMap.containsKey(label);
	}

	@Override
	public int get(String label) {
		return labelMap.get(label);
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
