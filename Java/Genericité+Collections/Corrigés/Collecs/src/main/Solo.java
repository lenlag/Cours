package main;

/**
 * 
 * @author 1802448
 *
 * @param <T>
 * 
 * Petit exemple de généricité
 */
public class Solo<T> {
	private T value;
	
	
	public Solo(T value) {
		super();
		this.value = value;
	}


	public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public static void main(String[] args) {
		Solo<String> stringSolo = new Solo<String>("TEST");
		System.out.println(stringSolo.getValue());

		Solo<Integer> intSolo = new Solo<Integer>(12);
		System.out.println(intSolo.getValue());
		
		Person p = new Person("Jean", "Bidule", 56);
		Solo<Person> personSolo = new Solo<Person>(p);
		System.out.println(personSolo.getValue().getNom());
		
	}

}
