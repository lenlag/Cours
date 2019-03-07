package entity;

import java.util.ArrayList;
import java.util.List;

import business.entity.BoutiqueItem;

public class Panier {
	List<PanierItem> list = new ArrayList<>();
	private int getIndexById(long id) {
		int i = 0;
		for (PanierItem pi:list) {
			if (pi.getId() == id) {
				return i; 
			}
			i++;
		}
		return -1;
	}
	public void add(BoutiqueItem bi) throws Exception {
		int idx = getIndexById(bi.getId());
		if (idx == -1) {
			list.add(new PanierItem(bi));
		} else {
			inc(bi.getId(),list.get(idx).getNb()+1,idx);
		}
	}
	private void inc(long id,int nb,int index) throws Exception {
		int idx = -1;
		if (index != -1) {
			idx = index;
		} else {
			idx = getIndexById(id);
		}
		if (idx == -1) {
			throw new Exception("id inconnu "+id);
		}
		PanierItem pi = list.get(idx);
		pi.setNb(nb);
		pi.processPrice();
	}
	public void delete(long id) throws Exception {
		int idx = getIndexById(id);
		if (idx == -1) {
			throw new Exception("id inconnu "+id);
		}
		list.remove(idx);
	}
	public void update(long id,int nb) throws Exception {
		inc(id,nb,-1);
	}
	public void updateAll(List<Integer> nbs) throws Exception  {
		for (int i = 0 ; i < nbs.size() ; i++) {
			update(list.get(i).getId(),nbs.get(i).intValue());
		}
	}
	public List<PanierItem> getList() {
		return list;
	}
	public void setList(List<PanierItem> list) {
		this.list = list;
	}
	
}
