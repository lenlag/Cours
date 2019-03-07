package business.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private long id;
	private String firstName;
	private String lastname;
	private int age;
	private List<Animal> list = new ArrayList<>();
	public Person(long id, String firstName, String lastname, int age, List<Animal> list) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.age = age;
		this.list = list;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Animal> getList() {
		return list;
	}
	public void setList(List<Animal> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", age=" + age + ", list="
				+ list + "]";
	}
	
	
}
