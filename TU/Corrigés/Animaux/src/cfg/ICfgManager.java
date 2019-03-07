package cfg;

import java.util.Properties;

/**
 * Interface for CfgManager
 * 
 * @author 1802448
 *
 */
public interface ICfgManager {
	/**
	 * Return the Cfg file content as Properties
	 *  
	 * @return Cfg file content as Properties
	 */
	public Properties getCfg();
}
