package objets;

import persistance.IPersistance;

public class Address implements IPersistance {
	private String id;
	private String address;
	private String zipCode;
	private String city;
	
	public Address(String address, String zipCode, String city) {
		this();
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toFile() {
		return address+","+zipCode+","+city;
	}
	
}
