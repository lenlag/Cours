package main;

import java.util.Set;
import java.util.TreeSet;

public class TheSetDevice {
	private Set<String> set = new TreeSet<>();
	
	public void add(String s) {
		if (s != null) {
			set.add(s);
		}
	}
	public void remove(String s) {
		if (s != null) {
			set.remove(s);
		}
	}
	public Set<String> list() {
		return set;
	}
	public void update(String oldValue,String newValue) {
		if ((oldValue != null) && (newValue != null)) {
			if (set.contains(oldValue) && !set.contains(newValue)) {
				set.remove(oldValue);
				set.add(newValue);
			}
		}
	}
}
