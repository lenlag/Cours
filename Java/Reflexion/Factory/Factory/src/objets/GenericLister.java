package objets;

import display.IDisplay;
import process.DisplayFactory;

public class GenericLister {
	protected IDisplay display;

	public GenericLister() throws Exception {
		super();
		display = DisplayFactory.newInstance();
	}
	
}
