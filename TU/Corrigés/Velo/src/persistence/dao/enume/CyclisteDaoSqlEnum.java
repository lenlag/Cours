package persistence.dao.enume;

public enum CyclisteDaoSqlEnum {
	prefix("c."),
	one("SELECT c.*,e.* FROM cycliste as c,equipe as e where c.equipe_id=e.id AND c.id=?"),
	create("INSERT INTO cycliste (name,nombre_velos,equipe_id) VALUES (?,?,?)"),
	update("UPDATE cycliste SET name=?,nombre_velos=?,equipe_id=? WHERE id=?"), 
	delete("DELETE FROM cycliste WHERE id=?"), 
	list("SELECT c.*,e.* FROM cycliste as c,equipe as e where c.equipe_id=e.id ");
	private String sql;
	private CyclisteDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
