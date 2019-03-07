package main.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFile {
	private List<List<String>> data;
	private List<String> titles;
	private String path;
	private String sep;
	private boolean isTitle;
	public CsvFile(String path,String sep,boolean isTitle) {
		this.path = path;
		this.sep = sep;
		this.isTitle = isTitle;
		titles = new ArrayList<>();
		data = new ArrayList<>();
	}
	public CsvFile(String path) {
		this(path,",",true);
	}
	
	public List<List<String>> getData() {
		return data;
	}
	
	public List<String> getTitles() {
		return titles;
	}
	private List<String> getValues(String s) {
		String[] array = s.split(sep);
		return Arrays.asList(array);
	}
	public void load() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			int idx = 0;
			while(true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				line = line.trim();
				// ligne vide
				if (line.length() == 0) {
					continue;
				}
				if ((idx == 0) && isTitle) {
					titles = getValues(line);
				} else {
					List<String> values = getValues(line);
					data.add(values);
				}
				idx++;
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
	public void display() {
		display(this.data);
	}
	public void display(List<List<String>> val) {
		if (isTitle) {
			System.out.print("[T]");
			for (String s:titles) {
				System.out.print(s+sep);
			}
			System.out.println();
		}
		for (List<String> l : val) {
			for (String s:l) {
				System.out.print(s+sep);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		CsvFile cf = new CsvFile("files/csv.txt");
		cf.load();
		List<List<String>> data = cf.getData();
		System.out.println("---------------------- Appel de display avec param");
		cf.display(data);
		System.out.println("---------------------- Appel de display sans param");
		cf.display();
		System.out.println("---------------------- Affichage des titres");
		List<String> titles = cf.getTitles();
		for (String s:titles) {
			System.out.print(s+" ");
		}
		System.out.println();
	}

}
