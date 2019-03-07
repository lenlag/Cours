package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import business.entity.User;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public class PwdChecker {
	public static final String USER_SQL = "SELECT * from _users where name=?";
	
	public User checkPwd(String login,String pwd) throws Exception {
		Connection cnx = null;
		String basePwd = null;
		String name = null;
		long id = 0L;
		boolean isAdmin = false;
		User user = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(USER_SQL);
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					basePwd = rs.getString("password");
					name = rs.getString("name");
					id = rs.getLong("id");
					isAdmin = (rs.getInt("isAdmin") == 1) ? true:false;
				}
				rs.close();
			}
			st.close();
			if (basePwd != null) {
				if (pwd.equals(basePwd)) {
					user = new User(id,name,basePwd,isAdmin);
				}
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		return user;
	}
}
