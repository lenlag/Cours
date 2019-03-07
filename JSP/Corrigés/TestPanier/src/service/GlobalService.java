package service;

import java.util.List;

import business.entity.BoutiqueItem;
import persistence.dao.BoutiqueDao;

public class GlobalService {
	private BoutiqueDao dao = new BoutiqueDao();
	
	public List<BoutiqueItem> list() throws Exception {
		return dao.findAll(); 
	}
	public BoutiqueItem findById(long id) throws Exception {
		return dao.findById(id);
	}
}
