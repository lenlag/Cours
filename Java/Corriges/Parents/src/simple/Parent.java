package simple;

public class Parent extends Person {
	public static final int MAX_SONS=10;
	public static final int MIN_AGE=17;
	
	private Enfant[] sons = new Enfant[MAX_SONS];
	private int nbSons = 0;
	
	public Parent() {
		super();
	}

	public Parent(String prenom, String nom, int age) {
		super(prenom, nom, age);
	}
	public void accouche() {
		if (getAge() > MIN_AGE ) {
			Enfant enfant = new Enfant("prenom-enfant-"+(nbSons+1),"nom-enfant-"+(nbSons+1),0);
			sons[nbSons++] = enfant;
			Log.log("Enfant créé");
		}
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
}
