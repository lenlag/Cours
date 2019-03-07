package objets;

import java.util.Arrays;
import java.util.List;

public class MemLister implements ILister {

	public MemLister() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> list() throws Exception {
		String[] a = {"Debut","Fin","Milieu","Quelque part"};
		return Arrays.asList(a);
	}

	@Override
	public void display() {
		System.out.println("MemLister");
	}

}
