package fr.afpa.formation.persistence;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=SmallApp.class)
public class SpecieMyTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SpecieRepository repo;	
    
	private int lBeginners;
	private int all;

    @Before
	public void setUp() {
		System.out.println("Before");
		Specie sp = new Specie();
		sp.setCommonName("COMMON");
		sp.setLatinName("LATIN");
		entityManager.persist(sp);
		sp = new Specie();
		sp.setCommonName("lapin");
		sp.setLatinName("LAPINUS");
		entityManager.persist(sp);
		sp = new Specie();
		sp.setCommonName("Glapin");
		sp.setLatinName("GLAPINUS");
		entityManager.persist(sp);
		lBeginners = 2;
		all = 3;
		
	}
    private Specie addSpecie() {
		Specie sp = new Specie();
		sp.setCommonName("XGlapin");
		sp.setLatinName("XGLAPINUS");
		entityManager.persist(sp);
		
		return sp;
    }
	@Test
	public void insert() {
		Specie sp = addSpecie();
		assertEquals(repo.count(),all+1);
		Specie test = repo.findById(sp.getId()).get();
		assertEquals(test.getCommonName(),sp.getCommonName());
		assertEquals(test.getLatinName(),sp.getLatinName());
	}
	@Test
	public void update() {
		Specie sp = addSpecie();
		String common = "Machin";
		sp.setCommonName(common);
		repo.save(sp);
		Specie test = repo.findById(sp.getId()).get();
		assertEquals(test.getCommonName(),sp.getCommonName());
		assertEquals(test.getLatinName(),sp.getLatinName());
	}
	@Test
	public void delete() {
		Specie sp = addSpecie();
		assertEquals(all+1,repo.count());
		repo.delete(sp);
		assertEquals(all,repo.count());
	}
	@Test
	public void findList() {
		assertEquals(repo.count(),all);
	}
	@Test
	public void findBeginList() {
		List<Specie> list = repo.findByBeginName("L");
		assertEquals(list.size(),lBeginners);
	}
}
