package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import business.entity.Animal;
import business.entity.Specie;
import persistence.dao.enume.AnimalDaoFieldEnum;
import persistence.dao.enume.AnimalDaoSqlEnum;
import persistence.dao.enume.SpecieDaoFieldEnum;
import persistence.dao.enume.SpecieDaoSqlEnum;

public class AnimalDAO extends AbstractDAO<Animal> implements IDAO<Animal> {

	@Override
	protected Animal fromResultSet(ResultSet rs) throws Exception {
		int id = rs.getInt(AnimalDaoSqlEnum.PREFIX.getSql()+AnimalDaoFieldEnum.ID.name());
		String name = rs.getString(AnimalDaoSqlEnum.PREFIX.getSql()+AnimalDaoFieldEnum.NAME.name());
		String color = rs.getString(AnimalDaoSqlEnum.PREFIX.getSql()+AnimalDaoFieldEnum.COLOR.name());
		String sex = rs.getString(AnimalDaoSqlEnum.PREFIX.getSql()+AnimalDaoFieldEnum.SEX.name());
		String common_name = rs.getString(SpecieDaoSqlEnum.PREFIX.getSql()+SpecieDaoFieldEnum.COMMON_NAME.name());
		String latin_name = rs.getString(SpecieDaoSqlEnum.PREFIX.getSql()+SpecieDaoFieldEnum.LATIN_NAME.name());
		int a_id = rs.getInt(SpecieDaoSqlEnum.PREFIX.getSql()+SpecieDaoFieldEnum.ID.name());
		if (a_id == 0) {
			return null;
		}
		Animal animal = new Animal(id,name,color,sex.charAt(0),null);
		Specie sp = new Specie(a_id,common_name,latin_name);
		animal.setSpecie(sp);
		return animal;
	}

	@Override
	protected PreparedStatement getListStatement(Connection cnx) throws Exception {
		PreparedStatement st = cnx.prepareStatement(AnimalDaoSqlEnum.list.getSql());
		return st;
	}

	@Override
	protected PreparedStatement getOneStatement(Connection cnx, long id) throws Exception {
		PreparedStatement st = cnx.prepareStatement(AnimalDaoSqlEnum.one.getSql());
		st.setLong(1, id);
		return st;
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection cnx, Animal ani) throws Exception {
		PreparedStatement st = cnx.prepareStatement(AnimalDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
		st.setString(1, ani.getName());
		st.setString(2, ani.getColor());
		char[] cs = {ani.getSex()};
		st.setString(3, new String(cs));
		st.setLong(4, ani.getSpecie().getId());
		return st;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection cnx, Animal ani) throws Exception {
		PreparedStatement st = cnx.prepareStatement(AnimalDaoSqlEnum.update.getSql());
		st.setString(1, ani.getName());
		st.setString(2, ani.getColor());
		char[] cs = {ani.getSex()};
		st.setString(3, new String(cs));
		st.setLong(4, ani.getSpecie().getId());
		st.setLong(5, ani.getId());
		return st;
	}

	@Override
	protected PreparedStatement getDeleteStatement(Connection cnx, long id) throws Exception {
		PreparedStatement st = cnx.prepareStatement(AnimalDaoSqlEnum.delete.getSql());
		st.setLong(1, id);
		return st;
	}

	@Override
	protected void setId(Animal pT, long id) throws Exception {
		pT.setId(id);
	}

}
