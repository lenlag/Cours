package persistence.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import cfg.CfgManager;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;

public class JDBCManager implements IConnector {
	private static JDBCManager instance = null;
	private JDBCManager() throws DaoException {
		try {
			initialize(CfgManager.getInstance().getCfg());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	};
	public static JDBCManager getInstance() throws DaoException {
		if (instance == null) {
			instance = new JDBCManager();
		}
		return instance;
	}
	
	private Connection cnx = null;
	private Properties cfg = null;
	
	private void initialize(Properties cfg) throws DaoException {
		this.cfg = cfg;
		try {
			String driverName = cfg.getProperty(EnumJDBC.driverName.toString());
			if (driverName == null) {
				throw new DaoException(DaoExceptionEnum.IncorrectCfg.getText());
			}
			Class.forName(driverName);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public Connection getConnection() throws DaoException {
		if (cnx != null) {
			try {
				if (cnx.isClosed()) {
					cnx = null;
				}
			} catch (Exception ex) {
				throw new DaoException(ex);
			}
		}
		if (cnx == null) {
			String url = cfg.getProperty(EnumJDBC.url.toString());
			String user = cfg.getProperty(EnumJDBC.user.toString());
			String pwd = cfg.getProperty(EnumJDBC.password.toString());
			if ((pwd == null) || (user == null) || (url == null)) {
				throw new DaoException(DaoExceptionEnum.IncorrectCfg.getText());
			}
			try {
				cnx = DriverManager.getConnection(url, user, pwd);
			} catch (Exception ex) {
				throw new DaoException(ex);
			}
		}
		return cnx;
	}
	
	@Override
	public void close() throws DaoException {
		try {
			if (cnx != null) {
				if (!cnx.isClosed()) {
					cnx.close();
					cnx = null;
				}
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}
	
}
