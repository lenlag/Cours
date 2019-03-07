package objets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class NetLister extends GenericLister implements ILister {
	private final static String MY_URL="http://montpellier.fr";

	public NetLister() throws Exception {
		super();
	}

	@Override
	public List<String> list() throws Exception {
		URL url = new URL(MY_URL);
		URLConnection cnx = null;
		BufferedReader br = null;
		try { 
			cnx = url.openConnection();
			br = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
			List<String> list = new ArrayList<>();
			while(true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}
			return list;
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	@Override
	public void display() {
		display.display("DISPLAY : NetLister");
	}

}
