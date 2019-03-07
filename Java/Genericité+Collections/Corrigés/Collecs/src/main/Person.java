package main;

public class Person {
	private String prenom;
	private String nom;
	private int age;
	
	public Person(String prenom, String nom, int age) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Person clone() {
		return new Person(prenom,nom,age);
	}

	@Override
	public String toString() {
		return "Person [prenom=" + prenom + ", nom=" + nom + ", age=" + age + "]";
	}
	
}
