package persistence.dao;

import java.util.List;

import business.entity.Moteur;
import persistence.pere.TU_Pere;

public class TestMoteurDAO extends TU_Pere {
	private MoteurDAO dao = new MoteurDAO();
	
	public void testList() throws Exception {
		List<Moteur> list = dao.findList();
		int realNb = getInserter().select("select count(id) from Moteur").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		Moteur sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(1,sp.getId());
	}
	
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from Moteur").getDataAsInt();
		Moteur sp = new Moteur("Maxou","gazou",1600);
		try {
			dao.create(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from Moteur").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Moteur sp2 = dao.findById(sp.getId());
		assertEquals(sp.getMarque(),sp2.getMarque());
		assertEquals(sp.getModele(),sp2.getModele());
		assertEquals(sp.getCylindree(),sp2.getCylindree());
	}
	
	public void testUpdate() throws Exception {
		Moteur sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(1,sp.getId());
		try {
			dao.updateById(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		String name = "Dominus";
		sp.setMarque(name);
		dao.updateById(sp);
		sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(name, sp.getMarque());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from Moteur").getDataAsInt();
		Moteur sp = new Moteur("Bonobo","Kikou",1200);
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from Moteur").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(sp.getId());
		newNb = getInserter().select("select count(id) from Moteur").getDataAsInt();
		assertEquals(initNb,newNb);
		assertNull(dao.findById(sp.getId()));
	}
	
}
