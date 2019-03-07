package main;

public class Parent extends Person {
	public static final int MAX_SONS=10;
	public static final int MIN_AGE=17;
	
	private Parent[] sons = new Parent[MAX_SONS];
	private int nbSons = 0;
	
	public Parent() {
		super();
	}

	public Parent(String prenom, String nom, int age) {
		super(prenom, nom, age);
	}
	public void accouche() {
		if (nbSons >= MAX_SONS) {
			Log.log("Maximum d'enfants atteint");
			return;
		}
		if (getAge() <= MIN_AGE ) {
			Log.log("L'age minimum est de "+MIN_AGE+1+" pour accoucher");
			return;
		}
		Parent enfant = new Parent("prenom-enfant-"+(nbSons+1),"nom-enfant-"+(nbSons+1),0);
		sons[nbSons++] = enfant;
	}
	
	public String toString() {
		String s = super.toString()+"\r\n";
		if (nbSons > 0) {
			s += "Enfants :\r\n";
			for (int i = 0 ; i < nbSons ; i++) {
				s += sons[i].toString();
			}
			s+="\r\n";
		}
		return s;
	}
	public Parent getEnfant(int i) {
		if (i >= nbSons) {
			return null;
		}
		return sons[i];
	}
}
