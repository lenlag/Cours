package persistence.dao;

import java.util.List;

import business.entity.Frein;
import business.entity.Moteur;
import business.entity.Voiture;
import persistence.pere.TU_Pere;

public class TestVoitureDAO extends TU_Pere {
	private VoitureDAO dao = new VoitureDAO();
	private FreinDAO fdao = new FreinDAO();
	private MoteurDAO mdao = new MoteurDAO();
	
	public void testList() throws Exception {
		List<Voiture> list = dao.findList();
		int realNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		Voiture sp = dao.findById(1);
		assertEquals(1,sp.getId());
	}
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		try {
			dao.create(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		Frein frein = fdao.findById(1);
		Moteur moteur = mdao.findById(1);
		assertNotNull(frein);
		assertNotNull(moteur);
		Voiture voiture = new Voiture("Raouf", "22L",frein,moteur);
		dao.create(voiture);
		int newNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Voiture v2 = dao.findById(voiture.getId());
		assertEquals(voiture.getMarque(),v2.getMarque());
		assertEquals(voiture.getModele(),v2.getModele());
		assertEquals(voiture.getFrein().getMarque(), v2.getFrein().getMarque());
		assertEquals(voiture.getMoteur().getMarque(), v2.getMoteur().getMarque());
	}
	public void testUpdate() throws Exception {
		try {
			dao.updateById(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		Voiture voiture  = dao.findById(1);
		assertNotNull(voiture);
		assertEquals(1,voiture.getId());
		Frein frein = fdao.findById(3);
		Moteur moteur = mdao.findById(3);
		String name = "Dominus";
		voiture.setMarque(name);
		voiture.setFrein(frein);
		voiture.setMoteur(moteur);
		dao.updateById(voiture);
		voiture = dao.findById(1);
		assertEquals(name, voiture.getMarque());
		assertEquals(frein.getMarque(), voiture.getFrein().getMarque());
		assertEquals(moteur.getMarque(), voiture.getMoteur().getMarque());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		
		Frein frein = fdao.findById(1);
		Moteur moteur = mdao.findById(1);
		assertNotNull(frein);
		assertNotNull(moteur);
		Voiture voiture = new Voiture("Bonobo","fff",frein,moteur);
		dao.create(voiture);
		int newNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(voiture.getId());
		newNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(initNb,newNb);
		Voiture v2 = dao.findById(voiture.getId());
		assertNull(v2);
	}
}
