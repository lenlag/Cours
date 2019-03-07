package main;

public class Cart {
	private static final int MAX_ITEMS = 100;
	
	private ISellableItem[] items = new SellableItem[MAX_ITEMS];
	private int nbItems = 0;
	
	public Cart() {
	}

	@Override
	public String toString() {
		String s = "Contenu du panier : "+"\r\n";
		for (int i = 0 ; i < nbItems ; i++) {
			ISellableItem si = items[i];
			if (si != null) {
				s += si.toString()+"\r\n";
			}
		}
		return s;
	}
	
	public void add(ISellableItem item) {
		if (nbItems < MAX_ITEMS) {
			items[nbItems++] = item;
		}
	}
	// récupère l'index de l'item dont l'identifiant vaut id 
	private int getItemIndexById(int id) {
		for (int i = 0 ; i < nbItems ; i++) {
			ISellableItem si = items[i];
			if (si != null) {
				if (si.getId() == id) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public ISellableItem getItemById(int id) {
		int idx = getItemIndexById(id);
		if (idx != -1) {
			return items[idx];
		}
		return null;
	}
	public void setItemById(int id,ISellableItem item) {
		int idx = getItemIndexById(id);
		if (idx != -1) {
			items[idx] = item;
		}
	}
	private void reformatArray() {
		for (int i = 0 ; i < nbItems ; i++) {
			if (items[i] == null) {
				if (i < nbItems-1) {
					items[i] = items[i+1];
					items[i+1] = null;
				}
			}
		}
	}
	
	public void deleteItemById(int id) {
		int idx = getItemIndexById(id);
		if (idx != -1) {
			items[idx] = null;
			reformatArray();
			nbItems--;
		}
	}
	
}
