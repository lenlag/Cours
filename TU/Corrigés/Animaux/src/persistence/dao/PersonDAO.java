package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import business.entity.Animal;
import business.entity.Person;
import persistence.dao.enume.PersonDaoFieldEnum;
import persistence.dao.enume.PersonDaoSqlEnum;

public class PersonDAO extends AbstractDAO<Person> {

	@Override
	protected Person fromResultSet(ResultSet rs) throws Exception {
		long id = rs.getLong(PersonDaoSqlEnum.PREFIX.getSql()+PersonDaoFieldEnum.ID.name());
		String firstName = rs.getString(PersonDaoSqlEnum.PREFIX.getSql()+PersonDaoFieldEnum.FIRSTNAME.name());
		String lastName = rs.getString(PersonDaoSqlEnum.PREFIX.getSql()+PersonDaoFieldEnum.LASTNAME.name());
		int age = rs.getInt(PersonDaoSqlEnum.PREFIX.getSql()+PersonDaoFieldEnum.AGE.name());
		Animal a = new AnimalDAO().fromResultSet(rs);
		List<Animal> list = new ArrayList<>();
		if (a != null) {
			list.add(a);
		}
		return new Person(id, firstName, lastName, age, list);
	}

	@Override
	protected PreparedStatement getListStatement(Connection cnx) throws Exception {
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.list.getSql());
		return st;
	}

	@Override
	protected PreparedStatement getOneStatement(Connection cnx, long id) throws Exception {
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.one.getSql());
		st.setLong(1, id);
		return st;
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection cnx, Person pT) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
		st.setString(1, pT.getFirstName());
		st.setString(2, pT.getLastname());
		st.setInt(3, pT.getAge());
		return st;
	}

	@Override
	protected List<PreparedStatement> getSubCreateStatement(Connection cnx,Person pT) throws Exception {
		List<PreparedStatement> list = new ArrayList<>();
		for (Animal ani:pT.getList()) {
			PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.createSub.getSql());
			st.setLong(1,pT.getId());
			st.setLong(2, ani.getId());
			list.add(st);
		}
		return list;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection cnx, Person pT) throws Exception {
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.update.getSql());
		st.setString(1, pT.getFirstName());
		st.setString(2, pT.getLastname());
		st.setInt(3, pT.getAge());
		st.setLong(4, pT.getId());
		return st;
	}
	
	@Override
	protected List<PreparedStatement> getSubUpdateStatement(Connection cnx,Person pT) throws Exception {
		List<PreparedStatement> list = new ArrayList<>();
		// detruire d'abord toutes les entrées
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.deleteSub.getSql());
		st.setLong(1,pT.getId());
		list.add(st);
		for (Animal ani:pT.getList()) {
			st = cnx.prepareStatement(PersonDaoSqlEnum.createSub.getSql());
			st.setLong(1,pT.getId());
			st.setLong(2, ani.getId());
			list.add(st);
		}
		return list;
	}

	@Override
	protected PreparedStatement getDeleteStatement(Connection cnx, long id) throws Exception {
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.delete.getSql());
		st.setLong(1,id);
		return st;
	}
	@Override
	protected List<PreparedStatement> getSubDeleteStatement(Connection cnx,long id) throws Exception {
		List<PreparedStatement> list = new ArrayList<>();
		PreparedStatement st = cnx.prepareStatement(PersonDaoSqlEnum.deleteSub.getSql());
		st.setLong(1, id);
		list.add(st);
		return list;
	}

	@Override
	protected void setId(Person pT, long id) throws Exception {
		pT.setId(id);
	}

	@Override
	protected List<Person> orderBy(List<Person> list) {
		Map<Long,List<Animal>> ids = new HashMap<>();
		List<Person> newList = new ArrayList<>();
		for (Person p:list) {
			long id = p.getId();
			List<Animal> listAnimal = ids.get(id);
			if (listAnimal == null) {
				listAnimal = new ArrayList<>();
				ids.put(id,listAnimal);
			}
			listAnimal.addAll(p.getList());
		}
		for (long id:ids.keySet()) {
			Person myP = null;
			for (Person p:list) {
				if (p.getId() == id) {
					myP = p;
					break;
				}
			}
			if (myP == null) {
				continue;
			}
			myP.setList(ids.get(myP.getId()));
			newList.add(myP);
		}
		return newList;
	}

}
