package main;

import java.util.Scanner;

public class Test {
	
	public static Parent getEnfant (String val,Parent parent) {
		Parent enfant = parent;
		for (int i = 1; i < val.length(); i++) {
			int rang;
			try {
				rang = Integer.parseInt(""+val.charAt(i));
			} catch (Exception ex) {
				return null;
			}
			Parent son =  enfant.getEnfant(rang);
			if (son == null) {
				return enfant;
			}
			enfant = son;
		}
		return enfant;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Parent parent = new Parent ("Jean","Valjean",10);
		// 8 fois
		parent.grandir();
		parent.grandir();
		parent.grandir();
		parent.grandir();
		parent.grandir();
		parent.grandir();
		parent.grandir();
		parent.grandir();
		// 3 fois
		parent.accouche();
		parent.accouche();
		parent.accouche();
		// affichage
		parent.toString();
		/*
		boolean exit = false;
		while(!exit) {
			Log.log("g pour grandir, g0... faire grandir l'enfant de rang 0, pour a pour accoucher, a0... , x pour sortir");
			Log.log("");
			
			String val = sc.next();
			switch (val.charAt(0)) {
				case 'x':
					exit = true;
					break;
				case 'g':
					if (val.length() == 1) {
						parent.grandir();
					} else {
						Parent enfant = getEnfant(val,parent);
						if (enfant != null) {
							enfant.grandir();
						}
					}
					break;
				case 'a':
					if (val.length() == 1) {
						parent.accouche();
					} else {
						Parent enfant = getEnfant(val,parent);
						if (enfant != null) {
							enfant.accouche();
						}
					}
					break;
			}
			Log.log(parent.toString());
		}
		*/
	}

}
