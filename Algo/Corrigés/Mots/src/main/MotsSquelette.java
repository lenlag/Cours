package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MotsSquelette {

	public static List<String> fromFile() throws Exception {
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("mots/liste.de.mots.francais.frgut.txt"),StandardCharsets.ISO_8859_1));
			while(true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				if (s.trim().length() == 0) {
					continue;
				}
				list.add(s);
			}
		} finally {
			br.close();
		}
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		List<String> mots = fromFile();

	}

}
