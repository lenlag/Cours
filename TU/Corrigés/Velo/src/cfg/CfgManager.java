package cfg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class that manages the Cfg file
 * 
 * @author 1802448
 *
 */
public class CfgManager implements ICfgManager {
	private static CfgManager instance = null;
	private CfgManager() throws CfgException {
		loadCfg();
	};
	public static CfgManager getInstance() throws CfgException {
		if (instance == null) {
			instance = new CfgManager();
		}
		return instance;
	}
	
	/**
	 * Constant of the System variable that indicates the Cfg file is at another place (in the project) than default
	 */
	public static final String OTHER_CFG_FILE_KEY = "OTHER_CFG_FILE";
	/**
	 * Constant of the System variable that indicates the Cfg file is at another place (in the file system) than default
	 */
	public static final String EXTERNAL_CFG_FILE_KEY = "EXTERNAL_CFG_FILE";
	/**
	 * Constant of the default relative path of the Cfg File
	 */
	public static final String CFG_FILE = "files/cfg.ini";
	
	/**
	 * The Content of the Cfg file as Properties
	 */
	private Properties cfg = null;
	
	@Override
	public Properties getCfg() {
		return cfg;
	}
	
	/**
	 * Load the cfg file
	 * @throws CfgException
	 */
	private void loadCfg() throws CfgException {
		cfg = new Properties();
		InputStream fis = null;
		try {
			String file = System.getProperty(EXTERNAL_CFG_FILE_KEY);
			if (file != null) {
				fis = new FileInputStream(file);
			} else {
				file = System.getProperty(OTHER_CFG_FILE_KEY);
				if (file == null) {
					file = CFG_FILE;
				}
				fis = this.getClass().getClassLoader().getResourceAsStream(file);
			}
			if (fis == null) {
				throw new CfgException(CfgErrorEnum.No_File.getError()); 
			}
			cfg.load(fis);
		} catch (Exception e) {
			throw new CfgException(e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					throw new CfgException(e);
				}
			}
		}
	}
	
}
