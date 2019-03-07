package main;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import junit.framework.TestCase;

public class TestMyFileManager extends TestCase {
	
	private String path = "c:/data/myfile";
	private MyFileManager fm = null;
	private int nbInitLines = 0;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		PrintWriter pw = new PrintWriter(new FileWriter(path));
		pw.println("AAA");
		pw.println("BBB");
		pw.println("CCC");
		pw.close();
		nbInitLines = 3;
		fm = new MyFileManager(path);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testList() {
		List<String> list = fm.list();
		assertEquals(list.size(),nbInitLines);
	}
	public void testSize() {
		long size = fm.size();
		assertEquals(size, new File(path).length());
	}
	public void testAppend() throws Exception {
		String s = "DDD";
		fm.append(s);
		List<String> list = fm.list();
		assertEquals(list.size(), nbInitLines+1);
		assertEquals(list.get(list.size()-1), s);
	}
	public void testRemove() throws Exception {
		String s = "XXX";
		fm.remove(s);
		List<String> list = fm.list();
		assertEquals(list.size(), nbInitLines);
		
		s = "AAA";
		fm.remove(s);
		list = fm.list();
		assertEquals(list.size(), nbInitLines-1);
		assertNotEquals(list.get(0),s);
	}
}
