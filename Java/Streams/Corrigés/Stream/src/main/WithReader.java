package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author 1802448
 *
 * Le même avec des Reader/Writer
 */
public class WithReader {
	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;
		String result = "";
		char[] bs = new char[1024];
		
		try {
			reader = new FileReader("file/alire");
			writer = new FileWriter("file/ecrire-reader");
			while(true) {
				int nb = reader.read(bs);
				if (nb == -1) {
					break;
				}
				result += new String(bs,0,nb);
				writer.write(bs,0, nb);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException ioe2) {
				ioe2.printStackTrace();
			}
		}
		System.out.println(result);
	}
}
