package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import entity.Liste;

public class ListService {
	private static final String KEY="__LISTE";
	
	public void add(HttpSession session,String name) {
		Liste liste =  (Liste)session.getAttribute(KEY);
		if (liste == null) {
			liste = new Liste();
			session.setAttribute(KEY, liste);
		}
		liste.add(name);
	}
	public void delete(HttpSession session,int idx) throws Exception {
		Liste liste =  (Liste)session.getAttribute(KEY);
		if (liste == null) {
			throw new Exception("Session vide");
		}
		liste.delete(idx);
	}
	public List<String> list(HttpSession session) {
		Liste liste =  (Liste)session.getAttribute(KEY);
		if (liste == null) {
			liste = new Liste();
			session.setAttribute(KEY, liste);
		}
		return liste.list();
	}
}
