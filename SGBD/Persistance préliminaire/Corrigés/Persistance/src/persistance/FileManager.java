package persistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that manages the files. For each class there a file associated and the name of the file is the id of the class. File are CSV files.
 * 
 * @author 1802448
 *
 */
public class FileManager {
	private static final String SEPARATOR=",";
	
	private static FileManager instance = null;
	private FileManager() {};
	public static FileManager getInstance() {
		if (instance == null) {
			instance = new FileManager();
		}
		return instance;
	}
	
	/**
	 * Transform a list into a String with separators
	 * 
	 * @param List List to be transformed
	 * @return The String with separators
	 */
	private String listToString(List<String> list) {
		String ret = "";
		for (String s:list) {
			ret += s+SEPARATOR;
		}
		ret = ret.substring(0,ret.length()-1);
		
		return ret;
	}
	/**
	 * Transform a String with separators into a list
	 * @param s  String to be transformed
	 * @return The list
	 */
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<>();
		String[] a = s.split(SEPARATOR);
		for (String i:a) {
			list.add(i);
		}
		return list;
	}
	/**
	 * Save a class into a file
	 * 
	 * @param p An IO class associated to a class
	 * @throws Exception
	 */
	public void save(IIO p) throws Exception {
		List<String> list = p.toFile();
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("files/"+p.getBean().getId()));
			pw.println(listToString(list));
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	/**
	 * Load a class from a file
	 * @param p An IO class associated to a class
	 * @throws Exception
	 */
	public void load(IIO p) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("files/"+p.getBean().getId()));
			String tmp = br.readLine();
			if (tmp != null) {
				tmp = tmp.trim();
				p.fromFile(stringToList(tmp));
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
}
