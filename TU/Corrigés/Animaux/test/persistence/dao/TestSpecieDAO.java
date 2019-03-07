package persistence.dao;

import java.util.List;

import business.entity.Specie;
import persistence.pere.TU_Pere;

public class TestSpecieDAO extends TU_Pere {
	private SpecieDAO dao = new SpecieDAO();
	
	public void testList() throws Exception {
		List<Specie> list = dao.findList();
		int realNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		Specie sp = dao.findById(1);
		assertEquals(1,sp.getId());
	}
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from specie").getDataAsInt();
		Specie sp = new Specie(0,"Bonobo","Bonobus bonobus");
		assertNull(dao.create(null));
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Specie sp2 = dao.findById(sp.getId());
		assertEquals(sp.getCommonName(),sp2.getCommonName());
	}
	public void testUpdate() throws Exception {
		Specie sp = dao.findById(1);
		assertEquals(1,sp.getId());
		assertNull(dao.updateById(null));
		String latin = "Dominus";
		sp.setLatinName(latin);
		dao.updateById(sp);
		sp = dao.findById(1);
		assertEquals(latin, sp.getLatinName());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from specie").getDataAsInt();
		Specie sp = new Specie(0,"Bonobo","Bonobus bonobus");
		dao.create(sp);
		int newNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(sp.getId());
		newNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(initNb,newNb);
		try {
			dao.findById(sp.getId());
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}
}
