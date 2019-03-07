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
}
