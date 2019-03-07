package entity;

import java.util.ArrayList;
import java.util.List;

public class Liste {
	private List<String> liste = new ArrayList<String>();
	
	public void add(String name) {
		liste.add(name);
	}
	public void delete(int idx) {
		liste.remove(idx);
	}
	public List<String> list() {
		return liste;
	}
}
