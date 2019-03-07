package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Cycliste;
import business.entity.Equipe;
import persistence.dao.enume.CyclisteDaoFieldEnum;
import persistence.dao.enume.CyclisteDaoSqlEnum;
import persistence.dao.enume.EquipeDaoFieldEnum;
import persistence.dao.enume.EquipeDaoSqlEnum;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public class CyclisteDAO implements IDAO<Cycliste> {

	@Override
	public Cycliste create(Cycliste pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(CyclisteDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1,pT.getName());
			st.setInt(2, pT.getNbVelos());
			st.setLong(3, pT.getEquipe().getId());
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
	public Cycliste findById(long pId) throws DaoException {
		List<Cycliste> list = find(CyclisteDaoSqlEnum.one.getSql(),pId);
		if (list.size() > 1) {
			throw new DaoException(DaoExceptionEnum.MoreThanOne.getText());
		}
		
		return (list.size() == 0) ? null:list.get(0);
	}

	@Override
	public List<Cycliste> findList() throws DaoException {
		return find(CyclisteDaoSqlEnum.list.getSql(),0);
	}
	
	private List<Cycliste> find(String sql,long id) throws DaoException {
		List<Cycliste> list = new ArrayList<>();
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
				String eName = rs.getString(EquipeDaoSqlEnum.prefix.getSql()+EquipeDaoFieldEnum.name.name());
				long ebudget = rs.getLong(EquipeDaoSqlEnum.prefix.getSql()+EquipeDaoFieldEnum.budget.name());
				long eId = rs.getLong(EquipeDaoSqlEnum.prefix.getSql()+EquipeDaoFieldEnum.id.name());
				Equipe equipe= new Equipe(eId,eName,ebudget);
				long theId = rs.getLong(CyclisteDaoSqlEnum.prefix.getSql()+CyclisteDaoFieldEnum.id.name());
				String name = rs.getString(CyclisteDaoSqlEnum.prefix.getSql()+CyclisteDaoFieldEnum.name.name());
				int nbVelos = rs.getInt(CyclisteDaoSqlEnum.prefix.getSql()+CyclisteDaoFieldEnum.nombre_velos.name());
				list.add(new Cycliste(theId,name,nbVelos,equipe));
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
	public Cycliste updateById(Cycliste pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(CyclisteDaoSqlEnum.update.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pT.getName());
			st.setLong(2, pT.getNbVelos());
			st.setLong(3, pT.getEquipe().getId());
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
			PreparedStatement st = cnx.prepareStatement(CyclisteDaoSqlEnum.delete.getSql(),Statement.RETURN_GENERATED_KEYS);
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
