package main;

public class Test {

	public static void main(String[] args) {
		Machin m1 = new Machin();
		Machin m2 = new Machin();
		if (!m1.equals(m2)) {
			System.out.println("Normal : les 2 objets Machin ne sont pas identiques");
		}
		MySingleton s1 = MySingleton.getInstance();
		MySingleton s2 = MySingleton.getInstance();
		// c'est le même objet
		if (s1.equals(s2)) {
			System.out.println("Normal : les 2 objets MySingleton sont identiques");
		}
		m1.display();
		// on crée le problème
		int initialValue = 10;
		m1.setValue(initialValue);
		m2.setValue(20);
		if (m1.getValue() != initialValue) {
			System.out.println("Ah la la ... On a modifié la valeur du singleton et c'est pas bon");
		}
		if (s1.getValeur() != initialValue) {
			System.out.println("Ah la la (bis) ... On a modifié la valeur du singleton et c'est pas bon");
		}
	}

}
