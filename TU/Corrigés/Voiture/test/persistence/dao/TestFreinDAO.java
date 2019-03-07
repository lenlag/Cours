package persistence.dao;

import java.util.List;

import business.entity.Frein;
import persistence.pere.TU_Pere;

public class TestFreinDAO extends TU_Pere {
	private FreinDAO dao = new FreinDAO();
	
	public void testList() throws Exception {
		List<Frein> list = dao.findList();
		int realNb = getInserter().select("select count(id) from Frein").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		Frein sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(1,sp.getId());
	}
	
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from Frein").getDataAsInt();
		Frein sp = new Frein("Maxou","gazou");
		try {
			dao.create(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from Frein").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Frein sp2 = dao.findById(sp.getId());
		assertEquals(sp.getMarque(),sp2.getMarque());
		assertEquals(sp.getModele(),sp2.getModele());
	}
	
	public void testUpdate() throws Exception {
		Frein sp = dao.findById(1);
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
		int initNb = getInserter().select("select count(id) from Frein").getDataAsInt();
		Frein sp = new Frein("Bonobo","Kikou");
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from Frein").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(sp.getId());
		newNb = getInserter().select("select count(id) from Frein").getDataAsInt();
		assertEquals(initNb,newNb);
		assertNull(dao.findById(sp.getId()));
	}
	
}
