package persistence.dao.enume;

public enum EquipeDaoSqlEnum {
	prefix("e."),
	one("SELECT * FROM equipe where id=?"),
	create("INSERT INTO equipe (name,budget) VALUES (?,?)"),
	update("UPDATE equipe SET name=?,budget=? WHERE id=?"), 
	delete("DELETE FROM equipe WHERE id=?"), 
	list("SELECT * FROM equipe");
	private String sql;
	private EquipeDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
