package persistence;

import static org.junit.Assert.assertEquals;

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
public class MySpecieTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SpecieRepository repo;	
    
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
	}
	@Test
	public void findList() {
		assertEquals(repo.findByLatinName("LATIN").size(),1);
	}
	@Test
	public void findBeginList() {
		assertEquals(repo.findByBeginLatinName("LA").size(),2);
	}
	@Test
	public void insert() {
		Specie sp = new Specie();
		sp.setCommonName("Guzzu");
		sp.setLatinName("GuzzuNus");
		repo.save(sp);
		assertEquals(3, repo.count());
	}
}
