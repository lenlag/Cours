package process;

import java.io.FileInputStream;
import java.util.Properties;

import objets.ILister;

public class ListerFactory {
	private final static String FILE_PATH="files/lister.cfg";

	public static ILister newInstance() throws Exception {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);
			Properties p = new Properties();
			p.load(fis);
			return (ILister)Class.forName(p.getProperty("class")).newInstance();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}
