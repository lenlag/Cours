package main;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
/**
 * 
 * @author 1802448
 *
 *  - Lire une chaine de texte (donnée ici) pour établir la fréquence de chaque lettre à l'aide d'une map.
 *  - Afficher la map dans l'ordre décroissant depuis la fréquence la plus élevée  
 */
public class Compte {

	public static void main(String[] args) {
		String s = "package main;"+ 
					"public class Saisie {"+
			"public static String getInputString() throws Exception {"+
				"byte[] bs = new byte[255];"+
				"System.in.read(bs);"+
				"return new String(bs).trim();"+
			"}"+
			"public static int getInputInt() throws Exception {"+
				"String s = getInputString();"+
				"return Integer.parseInt(s);";
		
		Map<String,Integer>  hmap = new HashMap<>();
		for (int i = 0 ; i < s.length() ; i++) {
			String sub = ""+s.charAt(i);
			Integer nb = hmap.get(sub);
			if (nb == null) {
				hmap.put(sub, 1);
			} else {
				nb = new Integer(nb.intValue()+1);
				hmap.put(sub,nb);
			}
		}
		CompareDevice cd = new CompareDevice(hmap);
		SortedMap<String,Integer>  map = new TreeMap<>(cd);
		map.putAll(hmap);
		for (String key: map.keySet()) {
			System.out.println(key+" = "+map.get(key));
		}
		
	}

}
