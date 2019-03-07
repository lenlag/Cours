package persistence.dao.enume;

public enum VoitureDaoSqlEnum {
	prefix("v."),
	one("SELECT v.*,f.*,m.* FROM automobile as v,moteur as m,frein as f where m.id=v.moteur_id AND f.id=v.frein_id AND v.id=?"),
	create("INSERT INTO automobile (marque,modele,moteur_id,frein_id) VALUES (?,?,?,?)"),
	update("UPDATE automobile SET marque=?,modele=?,moteur_id=?,frein_id=? WHERE id=?"), 
	delete("DELETE FROM automobile WHERE id=?"), 
	list("SELECT v.*,f.*,m.* FROM automobile as v,moteur as m,frein as f where m.id=v.moteur_id AND f.id=v.frein_id ");
	private String sql;
	private VoitureDaoSqlEnum(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
