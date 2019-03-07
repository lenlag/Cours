package persistence.dao.enume;

public enum MoteurDaoSqlEnum {
	prefix("m."),
	one("SELECT * FROM moteur where id=?"),
	create("INSERT INTO moteur (marque,modele,cylindree) VALUES (?,?,?)"),
	update("UPDATE moteur SET marque=?,modele=?,cylindree=? WHERE id=?"), 
	delete("DELETE FROM moteur WHERE id=?"), 
	list("SELECT * FROM moteur");
	private String sql;
	private MoteurDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
