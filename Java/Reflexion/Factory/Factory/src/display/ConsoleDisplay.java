package display;

public class ConsoleDisplay implements IDisplay {

	@Override
	public void display(String s) {
		System.out.println(s);
	}

}
