package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Equipe;
import persistence.dao.enume.EquipeDaoFieldEnum;
import persistence.dao.enume.EquipeDaoSqlEnum;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public class EquipeDAO implements IDAO<Equipe> {

	@Override
	public Equipe create(Equipe pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(EquipeDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1,pT.getName());
			st.setLong(2, pT.getBudget());
			st.execute();
			ResultSet rs = st.getGeneratedKeys();
			if (rs != null) {
				while(rs.next()) {
					long id = rs.getLong("GENERATED_KEY");
					pT.setId(id);
				}
				rs.close();
			}
			st.close();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		return pT;
	}

	@Override
	public Equipe findById(long pId) throws DaoException {
		List<Equipe> list = find(EquipeDaoSqlEnum.one.getSql(),pId);
		if (list.size() > 1) {
			throw new DaoException(DaoExceptionEnum.MoreThanOne.getText());
		}
		
		return (list.size() == 0) ? null:list.get(0);
	}

	@Override
	public List<Equipe> findList() throws DaoException {
		return find(EquipeDaoSqlEnum.list.getSql(),0);
	}

	private List<Equipe> find(String sql,long id) throws DaoException {
		List<Equipe> list = new ArrayList<>();
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if (id != 0) {
				st.setLong(1, id);
			}
			ResultSet rs  = st.executeQuery();
			while(rs.next()) {
				long theId = rs.getLong(EquipeDaoFieldEnum.id.name());
				String name = rs.getString(EquipeDaoFieldEnum.name.name());
				long budget = rs.getLong(EquipeDaoFieldEnum.budget.name());
				list.add(new Equipe(theId,name,budget));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				JDBCManager.getInstance().close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		
		return list;
	}
	
	@Override
	public Equipe updateById(Equipe pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(EquipeDaoSqlEnum.update.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pT.getName());
			st.setLong(2, pT.getBudget());
			st.setLong(3, pT.getId());
			st.execute();
			st.close();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				JDBCManager.getInstance().close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
		return pT;
	}

	@Override
	public void deleteById(long pId) throws DaoException {
		if (pId == 0) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(EquipeDaoSqlEnum.delete.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, pId);
			st.execute();
			st.close();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				JDBCManager.getInstance().close();
			} catch (Exception e) {
				throw new DaoException(e);
			}
		}
	}
	
}
