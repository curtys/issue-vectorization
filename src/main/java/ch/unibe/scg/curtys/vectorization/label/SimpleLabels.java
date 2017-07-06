package ch.unibe.scg.curtys.vectorization.label;

import com.google.common.collect.HashBiMap;

/**
 * @author curtys
 */
public class SimpleLabels extends DefaultLabels {

	public SimpleLabels() {
		labelMap = HashBiMap.create();
		labelMap.put("BUG", 0);
		labelMap.put("IMPROVEMENT", 1);
		labelMap.put("RFE", 2);
	}

}
