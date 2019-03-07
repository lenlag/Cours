package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author 1802448
 *
 *
 * Le même avec un BufferedReader en écrivant sur la console dans la boucle.
 */
public class WithBufferedReader {
	public static void main(String[] args) {
		BufferedReader reader = null;
		String result = "";
		
		try {
			reader = new BufferedReader(new FileReader("file/alire"));
			while(true) {
				result = reader.readLine();
				if (result == null) {
					break;
				}
				System.out.println(result);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ioe2) {
				ioe2.printStackTrace();
			}
		}
	}
}
