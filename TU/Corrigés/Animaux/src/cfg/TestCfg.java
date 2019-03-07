package cfg;

import java.util.Properties;

public class TestCfg {

	public static void main(String[] args) throws CfgException {
		if (false) {
			System.setProperty(CfgManager.EXTERNAL_CFG_FILE_KEY, "c:\\data\\testdao.ini");
			Properties cfg = CfgManager.getInstance().getCfg();
			System.out.println(cfg);
		} else {
			System.setProperty(CfgManager.OTHER_CFG_FILE_KEY, "files/testcfg.ini");
			Properties cfg = CfgManager.getInstance().getCfg();
			System.out.println(cfg);
		}
	}

}
