package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Moteur;
import persistence.dao.enume.MoteurDaoFieldEnum;
import persistence.dao.enume.MoteurDaoSqlEnum;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public class MoteurDAO implements IDAO<Moteur> {

	@Override
	public Moteur create(Moteur pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(MoteurDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1,pT.getMarque());
			st.setString(2, pT.getModele());
			st.setInt(3, pT.getCylindree());
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
	public Moteur findById(long pId) throws DaoException {
		List<Moteur> list = find(MoteurDaoSqlEnum.one.getSql(),pId);
		if (list.size() > 1) {
			throw new DaoException(DaoExceptionEnum.MoreThanOne.getText());
		}
		
		return (list.size() == 0) ? null:list.get(0);
	}

	@Override
	public List<Moteur> findList() throws DaoException {
		return find(MoteurDaoSqlEnum.list.getSql(),0);
	}
	
	private List<Moteur> find(String sql,long id) throws DaoException {
		List<Moteur> list = new ArrayList<>();
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
				String marque = rs.getString(MoteurDaoFieldEnum.marque.name());
				String modele = rs.getString(MoteurDaoFieldEnum.modele.name());
				int cylindree = rs.getInt(MoteurDaoFieldEnum.cylindree.name());
				long mid = rs.getLong(MoteurDaoFieldEnum.id.name());
				list.add(new Moteur(mid,marque,modele,cylindree));
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
	public Moteur updateById(Moteur pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(MoteurDaoSqlEnum.update.getSql());
			st.setString(1, pT.getMarque());
			st.setString(2, pT.getModele());
			st.setInt(3, pT.getCylindree());
			st.setLong(4, pT.getId());
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
			PreparedStatement st = cnx.prepareStatement(MoteurDaoSqlEnum.delete.getSql());
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
