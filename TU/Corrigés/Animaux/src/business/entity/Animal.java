package business.entity;

public class Animal {
	private long id;
	private String name;
	private String color;
	private char sex;
	private Specie specie;
	
	public Animal(int id, String name, String color, char sex,Specie specie) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.sex = sex;
		this.specie = specie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specie getSpecie() {
		return specie;
	}

	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", color=" + color + ", sex=" + sex + ", specie=" + specie + "]";
	}
	
	
}
