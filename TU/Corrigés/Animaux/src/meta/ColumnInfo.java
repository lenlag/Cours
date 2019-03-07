package meta;

public class ColumnInfo {
	private String name;
	private String type;
	private String length;
	
	public ColumnInfo(String name, String type, String length) {
		super();
		this.name = name;
		this.type = type;
		this.length = length;
	}
	public ColumnInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "ColumnInfo [name=" + name + ", type=" + type + ", length=" + length + "]";
	}
	public ColumnInfo clone() {
		return new ColumnInfo(this.getName(),this.getType(),this.getLength());
	}
}
