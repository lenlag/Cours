package simple;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
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
		String s = parent.toString();
		Log.log(s);
	}

}
