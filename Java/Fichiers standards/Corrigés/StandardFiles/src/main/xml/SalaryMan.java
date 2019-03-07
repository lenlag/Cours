package main.xml;

public class SalaryMan {
	private String firstName;
	private String lastName;
	private String nickName;
	private int id;
	private int salary;
	public SalaryMan(String firstName, String lastName, String nickName, int id, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.id = id;
		this.salary = salary;
	}
	public SalaryMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "SalaryMan [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", id=" + id
				+ ", salary=" + salary + "]";
	}
	
	
}
