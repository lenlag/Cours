package process;

import objets.ILister;

public class ListerFactory extends GenericFactory {
	public static ILister newInstance() throws Exception {
		return (ILister) instanceThat("class");
	}
}
