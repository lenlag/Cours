package main;

import display.IDisplay;
import objets.FileLister;
import objets.ILister;
import objets.MemLister;
import objets.NetLister;
import process.DisplayFactory;
import process.ListerFactory;

public class Test {

	public static void main(String[] args) throws Exception {
		IDisplay display = DisplayFactory.newInstance();
		ILister lister = ListerFactory.newInstance();
		if (lister instanceof MemLister) {
			display.display("Objet de type MemLister");
		} else if (lister instanceof FileLister) {
			display.display("Objet de type FileLister");
		} else if (lister instanceof NetLister) {
			display.display("Objet de type NetLister");
		} else {
			display.display("Objet de type inconnu -> "+lister.getClass().getName());
		}
		lister.display();
		display.display("--------- Affichage du retour de list() --------------");
		for (String s:lister.list()) {
			display.display(s);
		}
	}

}
