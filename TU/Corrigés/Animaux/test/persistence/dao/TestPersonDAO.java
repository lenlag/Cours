package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Animal;
import business.entity.Person;
import persistence.pere.TU_Pere;

public class TestPersonDAO extends TU_Pere {
	private PersonDAO dao = new PersonDAO();
	private AnimalDAO adao = new AnimalDAO();
	
	public void testList() throws Exception {
		List<Person> list = dao.findList();
		int realNb = getInserter().select("select count(id) from Person").getDataAsInt();
		assertEquals(list.size(),realNb);
	}
	public void testOne() throws Exception {
		try {
			dao.findById(0);
			dao.findById(-1);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		Person sp = dao.findById(1);
		assertEquals(1,sp.getId());
	}
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from Person").getDataAsInt();
		Animal ani = adao.findById(1);
		assertNull(dao.create(null));
		List<Animal> anis = new ArrayList<>();
		anis.add(ani);
		Person p = new Person(0, "Maxime", "Duchamp", 54, anis);
		dao.create(p);
		int newNb = getInserter().select("select count(id) from Person").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Person p2 = dao.findById(p.getId());
		assertEquals(p.getFirstName(),p2.getFirstName());
		assertEquals(1,p2.getList().size());
		if ((p2.getList() != null) && (p2.getList().size() > 0)) {
			assertEquals(ani.getName(),p2.getList().get(0).getName());
		}
	}
	public void testUpdate() throws Exception {
		Person p = dao.findById(1);
		assertEquals(1,p.getId());
		assertNull(dao.updateById(null));
		Animal ani = adao.findById(3);
		List<Animal> anis = new ArrayList<>();
		anis.add(ani);
		String firstName = "Georges";
		p.setList(anis);
		p.setFirstName(firstName);
		dao.updateById(p);
		p = dao.findById(1);
		assertEquals(firstName, p.getFirstName());
		assertEquals(p.getList().size(), anis.size());
		assertEquals(p.getList().get(0).getName(), ani.getName());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from Person").getDataAsInt();
		Person p = new Person(0, "Maxime", "Duchamp", 54, new ArrayList<>());
		dao.create(p);
		int newNb = getInserter().select("select count(id) from Person").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(p.getId());
		newNb = getInserter().select("select count(id) from Person").getDataAsInt();
		assertEquals(initNb,newNb);
		try {
			dao.findById(p.getId());
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}
}
