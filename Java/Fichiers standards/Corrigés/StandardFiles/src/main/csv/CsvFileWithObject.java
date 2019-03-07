package main.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileWithObject {
	private List<Person> data;
	private List<String> titles;
	private String path;
	private String sep;
	private boolean isTitle;
	public CsvFileWithObject(String path,String sep,boolean isTitle) {
		this.path = path;
		this.sep = sep;
		this.isTitle = isTitle;
		titles = new ArrayList<>();
		data = new ArrayList<>();
	}
	public CsvFileWithObject(String path) {
		this(path,",",true);
	}
	
	public List<Person> getData() {
		return data;
	}
	
	public List<String> getTitles() {
		return titles;
	}
	private List<String> getValues(String s) {
		String[] array = s.split(sep);
		return Arrays.asList(array);
	}
	private Person getPerson(String s) throws PersonException {
		String[] array = s.split(sep);
		return new Person(array[0],array[1],array[2],array[3]);
	}
	public void load() throws IOException,PersonException {
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
					data.add(getPerson(line));
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
	public void display(List<Person> val) {
		if (isTitle) {
			for (String s:titles) {
				System.out.print(s+sep);
			}
			System.out.println();
		}
		for (Person l : val) {
			System.out.println(l);
		}
	}
	public static void main(String[] args) throws IOException,PersonException {
		CsvFileWithObject cf = new CsvFileWithObject("files/csv.txt");
		cf.load();
		List<Person> data = cf.getData();
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
