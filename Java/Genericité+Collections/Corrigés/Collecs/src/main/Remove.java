package main;

import java.util.*;

/**
 * 
 * @author 1802448
 * 
 * Exercice : 
 * - Créer une liste de 10 chaines qui commence avec 0 à 9 avec un Math.random()
 * - Repérer dans une boucle les chaines qui commencent par un numero pair 
 * - effacer les numeros pairs après la boucle
 * - afficher la liste pour vérifier   
 *
 */
public class Remove {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0 ; i < 10 ; i++) {
			String s = i+"-"+Math.random();
			list.add(s);
		}
		List<String> toRemove = new ArrayList<>();
		for (String s : list) {
			String premier = s.substring(0,1);
			int val = Integer.parseInt(premier); 
			if (val % 2 == 0) {
				toRemove.add(s);
			}
		}
		list.removeAll(toRemove);
		for (String s:list) {
			System.out.println(s);
		}
	}
}

