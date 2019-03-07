package persistence.dao;

import java.util.List;

import business.entity.Equipe;
import persistence.pere.TU_Pere;

public class TestEquipeDAO extends TU_Pere {
	private EquipeDAO dao = new EquipeDAO();
	
	public void testList() throws Exception {
		List<Equipe> list = dao.findList();
		int realNb = getInserter().select("select count(id) from Equipe").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		Equipe sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(1,sp.getId());
	}
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from Equipe").getDataAsInt();
		Equipe sp = new Equipe(0,"Maxou",600);
		try {
			dao.create(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from Equipe").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Equipe sp2 = dao.findById(sp.getId());
		assertEquals(sp.getName(),sp2.getName());
	}
	public void testUpdate() throws Exception {
		Equipe sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(1,sp.getId());
		try {
			dao.updateById(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		String name = "Dominus";
		sp.setName(name);
		dao.updateById(sp);
		sp = dao.findById(1);
		assertNotNull(sp);
		assertEquals(name, sp.getName());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from Equipe").getDataAsInt();
		Equipe sp = new Equipe(0,"Bonobo",60000);
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from Equipe").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(sp.getId());
		newNb = getInserter().select("select count(id) from Equipe").getDataAsInt();
		assertEquals(initNb,newNb);
		assertNull(dao.findById(sp.getId()));
	}
}
