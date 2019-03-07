package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import persistence.manager.JDBCManager;

public class Main {

	public static void main(String[] args) throws Exception {
		Connection cnx = JDBCManager.getInstance().getConnection();
		/*PreparedStatement st = cnx.prepareStatement("SELECT * FROM SPECIE");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			System.out.println("common = "+rs.getString("COMMON_NAME"));
		}*/
		PreparedStatement st = cnx.prepareStatement("INSERT INTO SPECIE (COMMON_NAME,LATIN_NAME) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		st.setString(1, "Baleine");
		st.setString(2, "Balenus balenus");
		st.execute();
		ResultSet rs = st.getGeneratedKeys();
		while(rs.next()) {
			long id = rs.getLong("GENERATED_KEY");
			System.out.println("new key is "+id);
		}
		cnx.close();
	}
}
