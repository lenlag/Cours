package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Frein;
import persistence.dao.enume.FreinDaoFieldEnum;
import persistence.dao.enume.FreinDaoSqlEnum;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public class FreinDAO implements IDAO<Frein> {

	@Override
	public Frein create(Frein pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(FreinDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1,pT.getMarque());
			st.setString(2, pT.getModele());
			st.execute();
			ResultSet rs = st.getGeneratedKeys();
			if (rs != null) {
				while(rs.next()) {
					long id = rs.getLong("GENERATED_KEY");
					pT.setId(id);
					break;
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
	public Frein findById(long pId) throws DaoException {
		List<Frein> list = find(FreinDaoSqlEnum.one.getSql(),pId);
		if (list.size() > 1) {
			throw new DaoException(DaoExceptionEnum.MoreThanOne.getText());
		}
		
		return (list.size() == 0) ? null:list.get(0);
	}

	@Override
	public List<Frein> findList() throws DaoException {
		return find(FreinDaoSqlEnum.list.getSql(),0);
	}
	
	private List<Frein> find(String sql,long id) throws DaoException {
		List<Frein> list = new ArrayList<>();
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
				String marque = rs.getString(FreinDaoFieldEnum.marque.name());
				String modele = rs.getString(FreinDaoFieldEnum.modele.name());
				long fid = rs.getLong(FreinDaoFieldEnum.id.name());
				list.add(new Frein(fid,marque,modele));
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
	public Frein updateById(Frein pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(FreinDaoSqlEnum.update.getSql());
			st.setString(1, pT.getMarque());
			st.setString(2, pT.getModele());
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
			PreparedStatement st = cnx.prepareStatement(FreinDaoSqlEnum.delete.getSql());
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
