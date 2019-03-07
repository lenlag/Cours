package main;

import java.util.Comparator;
import java.util.Map;

public class CompareDevice implements Comparator<String> {
	private Map<String,Integer> map;
	
	public CompareDevice(Map<String,Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(String o1, String o2) {
		return map.get(o2)-map.get(o1);
	}

}
