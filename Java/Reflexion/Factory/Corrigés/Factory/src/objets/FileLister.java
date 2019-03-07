package objets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileLister implements ILister {
	private final static String FILE_PATH="files/csv.txt";

	public FileLister() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> list() throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(FILE_PATH));
			List<String> lines = new ArrayList<>();
			while(true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				lines.add(line);
			}
			return lines;
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	@Override
	public void display() {
		System.out.println("FileLister");
	}

}
