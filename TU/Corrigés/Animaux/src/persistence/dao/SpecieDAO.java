package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import business.entity.Specie;
import persistence.dao.enume.SpecieDaoFieldEnum;
import persistence.dao.enume.SpecieDaoSqlEnum;

public class SpecieDAO extends AbstractDAO<Specie> /*implements IDAO<Specie>*/ {

	@Override
	protected Specie fromResultSet(ResultSet rs) throws Exception {
		int id = rs.getInt(SpecieDaoFieldEnum.ID.name());
		String common = rs.getString(SpecieDaoFieldEnum.COMMON_NAME.name());
		String latin = rs.getString(SpecieDaoFieldEnum.LATIN_NAME.name());
		return new Specie(id, common, latin);
	}

	@Override
	protected PreparedStatement getListStatement(Connection cnx) throws Exception {
		PreparedStatement st = cnx.prepareStatement(SpecieDaoSqlEnum.list.getSql());
		return st;
	}

	@Override
	protected PreparedStatement getOneStatement(Connection cnx,long id) throws Exception {
		PreparedStatement st = cnx.prepareStatement(SpecieDaoSqlEnum.one.getSql());
		st.setLong(1, id);
		return st;
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection cnx,Specie sp) throws Exception {
		PreparedStatement st = cnx.prepareStatement(SpecieDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
		st.setString(1, sp.getCommonName());
		st.setString(2, sp.getLatinName());
		return st;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection cnx,Specie sp) throws Exception {
		PreparedStatement st = cnx.prepareStatement(SpecieDaoSqlEnum.update.getSql());
		st.setString(1, sp.getCommonName());
		st.setString(2, sp.getLatinName());
		st.setLong(3, sp.getId());
		return st;
	}

	@Override
	protected PreparedStatement getDeleteStatement(Connection cnx,long id) throws Exception {
		PreparedStatement st = cnx.prepareStatement(SpecieDaoSqlEnum.delete.getSql());
		st.setLong(1, id);
		return st;
	}

	@Override
	protected void setId(Specie pT, long id) {
		pT.setId(id);
	}
	/*
	@Override
	public Specie create(Specie pT) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specie findById(long pId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Specie> findList() throws DaoException {
		List<Specie> list = new ArrayList<>();
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(SpecieDaoSqlEnum.list.getSql());
			ResultSet rs  = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(SpecieDaoFieldEnum.ID.name());
				String common = rs.getString(SpecieDaoFieldEnum.COMMON_NAME.name());
				String latin = rs.getString(SpecieDaoFieldEnum.LATIN_NAME.name());
				Specie s = new Specie(id, common, latin);
				list.add(s);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				if (cnx != null) {
					cnx.isClosed();
				}
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		
		return list;
	}
	
	
	@Override
	public Specie updateById(Specie pT) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long pId) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	*/
	
}
