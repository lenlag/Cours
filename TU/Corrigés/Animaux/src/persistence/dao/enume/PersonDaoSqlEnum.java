package persistence.dao.enume;

public enum PersonDaoSqlEnum {
	PREFIX("p."),
	PREFIX_JOIN("pa."),
	one("SELECT * FROM PERSON as p LEFT JOIN person__animal as pa on pa.person_id=p.id LEFT JOIN animal as a on pa.animal_id=a.id LEFT JOIN specie s on a.id_specie=s.id where p.id=?"),
	create("INSERT INTO PERSON (FIRSTNAME,LASTNAME,AGE) VALUES (?,?,?)"),
	createSub("INSERT INTO PERSON__ANIMAL (PERSON_ID,ANIMAL_ID) VALUES (?,?)"),
	update("UPDATE PERSON SET FIRSTNAME=?,LASTNAME=?,AGE=? WHERE ID=?"), 
	updateSub("UPDATE PERSON__ANIMAL SET ANIMAL_ID=? WHERE PERSON_ID=?"),
	delete("DELETE FROM PERSON WHERE ID=?"), 
	deleteSub("DELETE FROM PERSON__ANIMAL WHERE PERSON_ID=?"),
	list("SELECT * FROM PERSON as p LEFT JOIN person__animal as pa on pa.person_id=p.id LEFT JOIN animal as a on pa.animal_id=a.id LEFT JOIN specie s on a.id_specie=s.id");
	private String sql;
	private PersonDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
