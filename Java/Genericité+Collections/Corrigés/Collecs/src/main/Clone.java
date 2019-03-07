package main;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * - Créer list1 avec 3 Person dedans
 * - Créer list2 a partir de list1 en CLONANT les élements
 * - Modifier les éléments de list1 (ex : age à 0)
 * - Afficher list2 pour vérifier que ça n'a pas bougé
 * 
 */
public class Clone {

	public static void main(String[] args) {
		List<Person> list1 = new ArrayList<Person>();
		list1.add(new Person("Marcel", "Duchamp",56));
		list1.add(new Person("Jean", "Valjean",83));
		list1.add(new Person("Albert", "Bidule",23));
		
		//afficher list1
		System.out.println("------- List1 -----------------------------------");
		for (Person p:list1) {
			System.out.println(p);
		}
		List<Person> list2 = new ArrayList<Person>();
		// copier list1 -> list2
		for (Person p:list1) {
			list2.add(p.clone());
		}
		//afficher list2
		System.out.println("------- List2 -----------------------------------");
		for (Person p:list2) {
			System.out.println(p);
		}
		//Modifier list1
		for (Person p:list1) {
			p.setAge(0);
		}
		//afficher list1
		System.out.println("------- List1 -----------------------------------");
		for (Person p:list1) {
			System.out.println(p);
		}
		//afficher list2
		System.out.println("------- List2 -----------------------------------");
		for (Person p:list2) {
			System.out.println(p);
		}
	}

}
