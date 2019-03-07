package persistence.dao;

import java.util.List;
import java.util.Map;

import business.entity.Cycliste;
import business.entity.Equipe;
import persistence.pere.TU_Pere;

public class TestCyclisteDAO extends TU_Pere {
	private CyclisteDAO dao = new CyclisteDAO();
	private EquipeDAO edao = new EquipeDAO();
	
	public void testList() throws Exception {
		List<Cycliste> list = dao.findList();
		int realNb = getInserter().select("select count(id) from cycliste").getDataAsInt();
		assertEquals(list.size(),realNb);
		// Hi-Level usage of Inserter - don't try to use it by yourself :)
		List<Map<String,String>> data = getInserter().select("select c.name as cname,c.id as cid,c.nombre_velos as cvelos,e.id as eid,e.name as ename,e.budget as ebudget from cycliste as c, equipe as e where c.equipe_id=e.id", false).getDataAsMapList();
		for (int i = 0 ; i < data.size() ; i++) {
			Map<String,String> expected = data.get(i);
			Cycliste actual = list.get(i);
			assertEquals(""+actual.getId(),expected.get("cid"));
			assertEquals(""+actual.getNbVelos(),expected.get("cvelos"));
			assertEquals(actual.getName(),expected.get("cname"));
			assertEquals(""+actual.getEquipe().getId(),expected.get("eid"));
			assertEquals(actual.getEquipe().getName(),expected.get("ename"));
			assertEquals(""+actual.getEquipe().getBudget(),expected.get("ebudget"));
		}
	}
	public void testOne() throws Exception {
		Cycliste sp = dao.findById(1);
		assertEquals(1,sp.getId());
		// Hi-Level usage of Inserter - don't try to use it by yourself :)
		String tmp = getInserter().select("select cycliste.name,cycliste.nombre_velos,equipe.id,equipe.name,equipe.budget from cycliste,equipe where cycliste.equipe_id=equipe.id AND cycliste.id="+1).getDataAsString();
		String[] a = tmp.split("\\t");
		assertEquals(a[0],sp.getName());
		assertEquals(a[1],""+sp.getNbVelos());
		assertEquals(a[2], ""+sp.getEquipe().getId());
		assertEquals(a[3], sp.getEquipe().getName());
		assertEquals(a[4], ""+sp.getEquipe().getBudget());
	}
	public void testCreate() throws Exception {
		int initNb = getInserter().select("select count(id) from Cycliste").getDataAsInt();
		try {
			dao.create(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		Equipe eq = edao.findById(1);
		assertNotNull(eq);
		Cycliste cyc = new Cycliste("Poulidor", 4, eq);
		dao.create(cyc);
		int newNb = getInserter().select("select count(id) from Cycliste").getDataAsInt();
		assertEquals(initNb+1,newNb);
		Cycliste cyc2 = dao.findById(cyc.getId());
		assertEquals(cyc.getName(),cyc2.getName());
		assertEquals(cyc.getEquipe().getName(), cyc2.getEquipe().getName());
	}
	public void testUpdate() throws Exception {
		try {
			dao.updateById(null);
			assertNotNull(null);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		Cycliste cyc  = dao.findById(1);
		assertNotNull(cyc);
		assertEquals(1,cyc.getId());
		Equipe eq = edao.findById(3);
		String name = "Dominus";
		cyc.setName(name);
		cyc.setEquipe(eq);
		dao.updateById(cyc);
		cyc = dao.findById(1);
		assertEquals(name, cyc.getName());
		assertEquals(eq.getName(), cyc.getEquipe().getName());
	}
	public void testDelete() throws Exception {
		int initNb = getInserter().select("select count(id) from Cycliste").getDataAsInt();
		
		Equipe eq = edao.findById(1);
		assertNotNull(eq);
		Cycliste cyc = new Cycliste("Bonobo",4,eq);
		dao.create(cyc);
		int newNb = getInserter().select("select count(id) from Cycliste").getDataAsInt();
		assertEquals(initNb+1,newNb);
		dao.deleteById(cyc.getId());
		newNb = getInserter().select("select count(id) from Cycliste").getDataAsInt();
		assertEquals(initNb,newNb);
		Cycliste cyc2 = dao.findById(cyc.getId());
		assertNull(cyc2);
	}
}
