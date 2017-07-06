package ch.unibe.scg.curtys.vectorization.label;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author curtys
 */
public class SimpleLabels extends DefaultLabels {

	private final BiMap<String, Integer> labelMap;
	private final Logger log = LoggerFactory.getLogger(SimpleLabels.class);

	public SimpleLabels() {
		labelMap = HashBiMap.create();
		labelMap.put("BUG", 0);
		labelMap.put("IMPROVEMENT", 1);
		labelMap.put("RFE", 2);
	}

}
