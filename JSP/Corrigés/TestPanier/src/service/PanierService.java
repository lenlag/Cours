package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import business.entity.BoutiqueItem;
import entity.Panier;
import entity.PanierItem;

public class PanierService {
	public static final String PANIER_KEY="__PANIER";

	private GlobalService service = new GlobalService();
	
	public void addInPanier(HttpSession session,long id) throws Exception {
		
		Panier panier = (Panier)session.getAttribute(PANIER_KEY);
		if (panier == null) {
			panier = new Panier();
			session.setAttribute(PANIER_KEY, panier);
		}
		BoutiqueItem bi = service.findById(id);
		if (bi == null) {
			throw new Exception("Pas de item associé à "+id);
		}
		panier.add(bi);
	}
	public void clearPanier(HttpSession session) {
		session.removeAttribute(PANIER_KEY);
	}
	public void removeInPanier(HttpSession session,long id) throws Exception {
		
		Panier panier = (Panier)session.getAttribute(PANIER_KEY);
		if (panier == null) {
			return;
		}
		panier.delete(id);
	}
	public void updatePanier(HttpSession session,long id,int nb) throws Exception {
		Panier panier = (Panier)session.getAttribute(PANIER_KEY);
		if (panier == null) {
			throw new Exception("Panier vide");
		}
		panier.update(id,nb);
	}
	public void globalUpdatePanier(HttpSession session,List<Integer> nbs) throws Exception {
		Panier panier = (Panier)session.getAttribute(PANIER_KEY);
		if (panier == null) {
			throw new Exception("Panier vide");
		}
		panier.updateAll(nbs);
	}
	public List<PanierItem> list(HttpSession session) {
		Panier panier = (Panier)session.getAttribute(PANIER_KEY);
		if (panier == null) {
			return new ArrayList<PanierItem>();
		}
		return panier.getList();
	}
	public double grandTotal(HttpSession session) {
		Panier panier = (Panier)session.getAttribute(PANIER_KEY);
		if (panier == null) {
			return 0.0;
		}
		double total = 0.0;
		for (PanierItem pi : panier.getList()) {
			total += pi.getPrice();
		}
		return total;
	}
}
