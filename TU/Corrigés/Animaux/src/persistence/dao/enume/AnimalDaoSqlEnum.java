package persistence.dao.enume;

public enum AnimalDaoSqlEnum {
	PREFIX("a."),
	one("SELECT * FROM ANIMAL as a,SPECIE as s WHERE a.ID_SPECIE=s.id AND a.id=?"),
	create("INSERT INTO ANIMAL (NAME,COLOR,SEX,ID_SPECIE) VALUES (?,?,?,?)"),
	update("UPDATE ANIMAL SET NAME=?,COLOR=?,SEX=?,ID_SPECIE=? WHERE ID=?"), 
	delete("DELETE FROM ANIMAL WHERE ID=?"), 
	list("SELECT a.*,s.* FROM ANIMAL as a,SPECIE as s WHERE a.ID_SPECIE=s.id;");
	private String sql;
	private AnimalDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
