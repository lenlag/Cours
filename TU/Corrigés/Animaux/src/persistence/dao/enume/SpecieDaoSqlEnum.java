package persistence.dao.enume;

public enum SpecieDaoSqlEnum {
	PREFIX("s."),
	one("SELECT * FROM SPECIE WHERE id=?"),
	create("INSERT INTO SPECIE (COMMON_NAME,LATIN_NAME) VALUES (?,?)"),
	update("UPDATE SPECIE SET COMMON_NAME=?,LATIN_NAME=? WHERE ID=?"), 
	delete("DELETE FROM SPECIE WHERE ID=?"), 
	list("SELECT * FROM SPECIE;");
	private String sql;
	private SpecieDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
