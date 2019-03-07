package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MyFileManager {
	private List<String> lines = new ArrayList<>();
	private String path;
	
	public MyFileManager(String path) throws Exception {
		this.path = path;
		load(path);
	}
	private void load(String path) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			while(true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				// if i make a trim(), \r\n is erased
				line = line.trim();
				lines.add(line);
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
	public List<String> list() {
		return lines;
	}
	public long size() {
		long count = 0L;
		for (String line:lines) {
			count += line.length();
			// count the removed \r\n
			count += "\r\n".length();
		}
		return count;
	}
	private void append(String line,boolean incList) throws Exception {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(path, "rw");
			raf.seek(new File(path).length());
			raf.writeChars(line+"\r\n");
			if (incList) {
				lines.add(line);
			}
		} finally {
			if (raf != null) {
				raf.close();
			}
		}
	}
	public void append(String line) throws Exception {
		append(line,true);
	}
	public void remove(String s) throws Exception {
		lines.remove(s);
		new File(path).delete();
		for (String line:lines) {
			append(line,false);
		}
	}
}
