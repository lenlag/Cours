package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author 1802448
 *
 * - Lire un fichier, concaténer ke contenu dans une chaine et afficher à la fin.
 * - En même temps qu'on lit écrire dans un autre fichier.
 */
public class Main {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String result = "";
		byte[] bs = new byte[1024];
		
		try {
			fis = new FileInputStream("file/alire");
			fos = new FileOutputStream("file/ecrire");
			while(true) {
				int nb = fis.read(bs);
				if (nb == -1) {
					break;
				}
				result += new String(bs,0,nb);
				fos.write(bs,0, nb);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ioe2) {
				ioe2.printStackTrace();
			}
		}
		System.out.println(result);
	}

}
