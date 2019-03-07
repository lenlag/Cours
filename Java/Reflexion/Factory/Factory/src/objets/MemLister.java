package objets;

import java.util.Arrays;
import java.util.List;

public class MemLister extends GenericLister implements ILister {

	public MemLister() throws Exception {
		super();
	}

	@Override
	public List<String> list() throws Exception {
		String[] a = {"Debut","Fin","Milieu","Quelque part"};
		return Arrays.asList(a);
	}

	@Override
	public void display() {
		display.display("DISPLAY : MemLister");
	}

}
