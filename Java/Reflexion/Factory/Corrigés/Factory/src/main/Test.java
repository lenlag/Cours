package main;

import objets.ILister;
import process.ListerFactory;

public class Test {

	public static void main(String[] args) throws Exception {
		ILister lister = ListerFactory.newInstance();
		lister.display();
		for (String s:lister.list()) {
			System.out.println(s);
		}
	}

}
