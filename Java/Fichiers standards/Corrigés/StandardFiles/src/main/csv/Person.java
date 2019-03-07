package main.csv;

public class Person {
	private String nom;
	private String prenom;
	private int age;
	private String email;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person(String nom, String prenom, int age, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
	}
	public Person(String nom, String prenom, String age, String email) throws PersonException {
		super();
		this.nom = nom;
		this.prenom = prenom;
		try {
			this.age = Integer.parseInt(age);
		} catch (Exception e) {
			throw new PersonException(e);
		}
		this.email = email;
	}
	public Person() {
	}
	@Override
	public String toString() {
		return "Person [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email + "]";
	}
}
