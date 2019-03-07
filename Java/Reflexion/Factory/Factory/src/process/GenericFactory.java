package process;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class GenericFactory {
	private final static String FILE_PATH="files/lister.cfg";
	
	public static Object instanceThat(String key) throws Exception {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);
			Properties p = new Properties();
			p.load(fis);
			return (Object)Class.forName(p.getProperty(key)).newInstance();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (fis != null) {
				fis.close();
			}
		}		
	}
}
