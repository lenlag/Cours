package persistence.dao;

import java.util.List;

import business.entity.Animal;
import business.entity.Specie;
import persistence.pere.TU_Pere;

public class TestAnimalDAO extends TU_Pere {
	private AnimalDAO dao = new AnimalDAO();
	private SpecieDAO sdao = new SpecieDAO();
	
	public void testList() throws Exception {
		List<Animal> list = dao.findList();
		int realNb = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		Animal sp = dao.findById(1);
		assertEquals(1,sp.getId());
	}
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from animal").getDataAsInt();
		Specie sp = sdao.findById(1);
		Animal a = new Animal(0,"Jex","Rouge",'M',sp);
		assertNull(dao.create(null));
		dao.create(a);
		int newNb = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Animal a2 = dao.findById(a.getId());
		assertEquals(a.getName(),a2.getName());
		assertEquals(a2.getSpecie().getCommonName(), sp.getCommonName());
	}
	public void testUpdate() throws Exception {
		Animal a = dao.findById(1);
		assertEquals(1,a.getId());
		assertNull(dao.updateById(null));
		String name = "Georges";
		a.setName(name);
		dao.updateById(a);
		a = dao.findById(1);
		assertEquals(name, a.getName());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from animal").getDataAsInt();
		Specie sp = sdao.findById(1);
		Animal a = new Animal(0,"toto","rouge",'M',sp);
		dao.create(a);
		int newNb = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(a.getId());
		newNb = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(initNb,newNb);
		try {
			dao.findById(a.getId());
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}
}
