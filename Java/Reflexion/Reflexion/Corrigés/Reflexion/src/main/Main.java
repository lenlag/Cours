package main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
	private int value = 5;
	public int square(Integer i) {
		return i*i;
	}
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) throws Exception {
		Class<?> klass = Main.class;
		Object o = klass.newInstance();
		// on récupère la fonction et on l'execute
		Method m = klass.getDeclaredMethod("square",Integer.class);
		Object ret = m.invoke(o,7);
		System.out.println(ret);
		// modif de la valeur d'un champ private
		Field f = klass.getDeclaredField("value");
		boolean access = f.isAccessible();
		f.setAccessible(true);
		f.setInt(o, 12);
		f.setAccessible(access);
		System.out.println(((Main)o).getValue());
	}

}
