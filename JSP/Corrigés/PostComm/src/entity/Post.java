package entity;

import java.util.ArrayList;
import java.util.List;

public class Post {
	private int id;
	private String text;
	private List<Comm> comms = new ArrayList<Comm>();
	private int lastCommId = 0;
	
	public Post(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public Post(String text) {
		super();
		this.text = text;
	}
	public Post() {
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
	public List<Comm> getComms() {
		return comms;
	}
	public void setComms(List<Comm> comms) {
		this.comms = comms;
	}
	public int getLastCommId() {
		return lastCommId;
	}
	public void setLastCommId(int lastId) {
		this.lastCommId = lastId;
	}
	
}
