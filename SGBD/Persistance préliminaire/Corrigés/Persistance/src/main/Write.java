package main;

import objets.Address;
import objets.Person;
import persistance.AddressIO;
import persistance.PersonIO;

public class Write{

	public static void main(String[] args) throws Exception {
		Person jean = new Person("Jean","Valjean",88);
		jean.setId("10");
		Address add = new Address("2 rue verte", "75000","Paris");
		add.setId("100");
		jean.setAddress(add);
		System.out.println(jean.toString());
		new PersonIO(jean).save();
		new AddressIO(add).save();

		Person paul = new Person("Paul","Machin",90);
		paul.setId("11");
		Address add2 = new Address("4 rue rouge", "34000","Montpeul");
		add2.setId("101");
		paul.setAddress(add2);
		System.out.println(paul.toString());
		new PersonIO(paul).save();
		new AddressIO(add2).save();

		Person max = new Person("Max","Lamenace",33);
		max.setId("12");
		Address add3 = new Address("17 rue orange", "72000","Qpart");
		add3.setId("102");
		max.setAddress(add3);
		System.out.println(max.toString());
		new PersonIO(max).save();
		new AddressIO(add3).save();
	}

}
