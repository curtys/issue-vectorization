package ch.unibe.scg.curtys.vectorization;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by scurty on 15.02.17.
 */
public class Labels {

	private final static BiMap<String, Integer> LABEL_MAP;
	private final static BiMap<String, Integer> BINARY_MAPPING;
	private static final Logger log = LoggerFactory.getLogger(Labels.class);
	private static BiMap<String, Integer> proxy;
	public static final int PROXY_MULTICLASS = 0;
	public static final int PROXY_BINARY = 1;
	private static final int DEFAULT_PSEUDONYM = 1;

	static {
		LABEL_MAP = HashBiMap.create();
		LABEL_MAP.put("BUG", 0);
		LABEL_MAP.put("IMPROVEMENT", 1);
//		LABEL_MAP.put("OTHER", 2);
		LABEL_MAP.put("REFACTORING", 2);
		LABEL_MAP.put("RFE", 3);

		BINARY_MAPPING = HashBiMap.create();
		BINARY_MAPPING.put("BUG", 0);
		BINARY_MAPPING.put("NOBUG", 1);

		proxy = LABEL_MAP;
	}

	public static boolean validateLabels(String... labels) {
		Set<String> checked = new HashSet<>();
		for (String label : labels) {
			if(!proxy.containsKey(label)) {
				log.warn("Label " + label + " not registered");
				return false;
			}
			checked.add(label);
		}
		if (checked.size() != proxy.size()) {
			for (String label :  proxy.keySet()) {
				if (!checked.contains(label))
					log.warn("Label " + label + " is registered but does never occur!");
			}
			return false;
		}
		return true;
	}

	public static boolean has(String label) {
		return proxy.containsKey(label);
	}

	public static int get(String label) {
		return proxy.get(label);
	}

	public static String getNaturalLabel(int classLabel) {
		return proxy.inverse().get(classLabel);
	}

	public static int size() {
		return proxy.size();
	}

	public static void proxy(int proxyFlag) {
		if(proxyFlag == PROXY_MULTICLASS) proxy = LABEL_MAP;
		else proxy = BINARY_MAPPING;
	}

	public static int pseudonym(String label) {
		return (BINARY_MAPPING.containsKey(label)) ? BINARY_MAPPING.get(label) : DEFAULT_PSEUDONYM;
	}

}
