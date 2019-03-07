package hello;

public class CartItem {
	private String label;
	private String code;
	private int price;
	private int quant;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(String label, String code, int price, int quant) {
		super();
		this.label = label;
		this.code = code;
		this.price = price;
		this.quant = quant;
	}
	
	
}
