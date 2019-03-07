package entity;

public class Comm {
	private int id;
	private String text;
	public Comm(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public Comm(String text) {
		super();
		this.text = text;
	}
	public Comm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
