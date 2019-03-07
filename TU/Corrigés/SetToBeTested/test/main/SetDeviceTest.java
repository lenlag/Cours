package main;

import junit.framework.TestCase;

public class SetDeviceTest extends TestCase {
	
	private TheSetDevice setDevice;
	private int nbInit = 0;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setDevice = new TheSetDevice();
		setDevice.list().add("AAA");
		setDevice.list().add("BBB");
		setDevice.list().add("CCC");
		nbInit = 3;
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testList() {
		assertEquals(setDevice.list().size(), nbInit);
	}
	
	public void testAdd() {
		// cas normal
		String s = "DDD";
		setDevice.add(s);
		assertEquals(setDevice.list().size(), nbInit+1);
		assertTrue(setDevice.list().contains(s));
		
		// cas pareil
		s = "DDD";
		setDevice.add(s);
		assertEquals(setDevice.list().size(), nbInit+1);
		
		// cas avec null
		setDevice.add(null);
		assertEquals(setDevice.list().size(), nbInit+1);
	}
	public void testRemove() {
		// cas normal
		String s = "BBB";
		setDevice.remove(s);
		assertEquals(setDevice.list().size(), nbInit-1);
		assertFalse(setDevice.list().contains(s));
		
		// cas avec null
		setDevice.remove(null);
		assertEquals(setDevice.list().size(), nbInit-1);
	}
	public void testUpdate () throws Exception {
		// update sur une valeur qui n'existe pas -> il ne se passe rien
		String old = "XXX";
		String newVal = "EEE";
		setDevice.update(old, newVal);
		assertEquals(setDevice.list().size(), nbInit);
		assertFalse(setDevice.list().contains(newVal));
		
		// cas normal
		old = "CCC";
		setDevice.update(old, newVal);
		assertEquals(setDevice.list().size(), nbInit);
		assertTrue(setDevice.list().contains(newVal));
		assertFalse(setDevice.list().contains(old));
		
		// cas avec les null
		old = newVal;
		setDevice.update(old,null);
		assertTrue(setDevice.list().contains(old));
		newVal = "FFF";
		setDevice.update(null,newVal);
		assertFalse(setDevice.list().contains(newVal));
		setDevice.update(null,null);
		assertTrue(setDevice.list().contains(old));
		
		setUp();
		// test si la nouvelle valeur existe
		old = "AAA";
		newVal = "BBB";
		setDevice.update(old,newVal);
		assertEquals(setDevice.list().size(), nbInit);
		assertTrue(setDevice.list().contains(old));
	}
}
