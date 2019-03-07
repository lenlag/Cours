package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 1802448
 *
 * Faire un tirage de 100 entiers entre 0 et 10 à l'aide d'une Math.random
 * Ranger ces tirages dans une map à 2 clés : "PAIR" et "IMPAIR"
 */
public class Random {

	public static void main(String[] args) {
		Map<String,List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> pair = new ArrayList<>(); 
		List<Integer> impair = new ArrayList<>();
		map.put("IMPAIR", impair);
		map.put("PAIR", pair);
		for (int i = 0 ; i < 100 ; i++) {
			int val = (int)(Math.random() * 10.0);
			if (val % 2 == 0) {
				pair.add(val);
			} else {
				impair.add(val);
			}
		}
		
		for (String key : map.keySet()) {
			List<Integer> l = map.get(key);
			System.out.print(key+" ");
			for (Integer i : l) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
