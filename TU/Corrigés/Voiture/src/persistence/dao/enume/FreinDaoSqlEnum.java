package persistence.dao.enume;

public enum FreinDaoSqlEnum {
	prefix("f."),
	one("SELECT * FROM frein where id=?"),
	create("INSERT INTO frein (marque,modele) VALUES (?,?)"),
	update("UPDATE frein SET marque=?,modele=? WHERE id=?"), 
	delete("DELETE FROM frein WHERE id=?"), 
	list("SELECT * FROM frein");
	private String sql;
	private FreinDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
