package ps;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import persistence.manager.JDBCManager;

public class TryPS {

	public static void main(String[] args) throws Exception {
		try {
			System.out.println("Essai d'une PS sans parametres");
			Connection cnx = JDBCManager.getInstance().getConnection();
			CallableStatement cs = cnx.prepareCall("call countPS()");
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				System.out.println("id = "+rs.getLong("id")+" common_name = "+rs.getString("common_name")+" latin_name = "+rs.getString("latin_name"));
			}
			
			System.out.println("Essai d'une PS avec parametreIN et parametre OUT");
			cs = cnx.prepareCall("call mycount(?,?)");
			cs.registerOutParameter(2, Types.INTEGER);
			cs.setString(1,"chien");
			cs.execute();
			System.out.println("nombre de chiens = "+cs.getInt(2));
		} finally {
			JDBCManager.getInstance().close();
		}
	}

}
