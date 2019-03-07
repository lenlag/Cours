package objets;

import persistance.IPersistance;

public class Person implements IPersistance {
	private String id;
	private String prenom;
	private String nom;
	private int age;
	private Address address;
	public Person(String prenom, String nom, int age) {
		this();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age  
				+ "]"+address.toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	} 
	
}
