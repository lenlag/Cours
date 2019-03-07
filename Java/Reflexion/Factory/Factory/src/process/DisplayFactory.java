package process;

import display.IDisplay;

public class DisplayFactory extends GenericFactory {
	public static IDisplay newInstance() throws Exception {
		return (IDisplay) instanceThat("display");
	}
}
