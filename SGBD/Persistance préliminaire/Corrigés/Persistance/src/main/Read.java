package main;

import objets.Address;
import objets.Person;
import persistance.AddressIO;
import persistance.PersonIO;

public class Read{

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setId("10");
		Address add = new Address();
		add.setId("100");
		AddressIO addio = new AddressIO(add);
		addio.load();
		new PersonIO(p).load();
		p.setAddress((Address)addio.getBean());
		System.out.println(p.toString());

	
		p = new Person();
		p.setId("11");
		add = new Address();
		add.setId("101");
		addio = new AddressIO(add);
		addio.load();
		new PersonIO(p).load();
		p.setAddress((Address)addio.getBean());
		System.out.println(p.toString());

		p = new Person();
		p.setId("12");
		add = new Address();
		add.setId("102");
		addio = new AddressIO(add);
		addio.load();
		new PersonIO(p).load();
		p.setAddress((Address)addio.getBean());
		System.out.println(p.toString());
	
	}

}
