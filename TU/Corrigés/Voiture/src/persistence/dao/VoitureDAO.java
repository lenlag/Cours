package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Frein;
import business.entity.Moteur;
import business.entity.Voiture;
import persistence.dao.enume.FreinDaoFieldEnum;
import persistence.dao.enume.FreinDaoSqlEnum;
import persistence.dao.enume.MoteurDaoFieldEnum;
import persistence.dao.enume.MoteurDaoSqlEnum;
import persistence.dao.enume.VoitureDaoFieldEnum;
import persistence.dao.enume.VoitureDaoSqlEnum;
import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public class VoitureDAO implements IDAO<Voiture> {

	@Override
	public Voiture create(Voiture pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(VoitureDaoSqlEnum.create.getSql(),Statement.RETURN_GENERATED_KEYS);
			st.setString(1,pT.getMarque());
			st.setString(2, pT.getModele());
			st.setLong(3, pT.getMoteur().getId());
			st.setLong(4, pT.getFrein().getId());
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
	public Voiture findById(long pId) throws DaoException {
		List<Voiture> list = find(VoitureDaoSqlEnum.one.getSql(),pId);
		if (list.size() > 1) {
			throw new DaoException(DaoExceptionEnum.MoreThanOne.getText());
		}
		
		return (list.size() == 0) ? null:list.get(0);
	}

	@Override
	public List<Voiture> findList() throws DaoException {
		return find(VoitureDaoSqlEnum.list.getSql(),0);
	}
	
	private List<Voiture> find(String sql,long id) throws DaoException {
		List<Voiture> list = new ArrayList<>();
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
				String vmarque = rs.getString(VoitureDaoSqlEnum.prefix.getSql()+VoitureDaoFieldEnum.marque.name());
				String vmodele = rs.getString(VoitureDaoSqlEnum.prefix.getSql()+VoitureDaoFieldEnum.modele.name());
				long vid = rs.getLong(VoitureDaoSqlEnum.prefix.getSql()+VoitureDaoFieldEnum.id.name());
				
				long fid = rs.getLong(FreinDaoSqlEnum.prefix.getSql()+FreinDaoFieldEnum.id.name());
				String fmarque = rs.getString(FreinDaoSqlEnum.prefix.getSql()+FreinDaoFieldEnum.marque.name());
				String fmodele = rs.getString(FreinDaoSqlEnum.prefix.getSql()+FreinDaoFieldEnum.modele.name());
				Frein frein = new Frein(fid,fmarque,fmodele);

				long mid = rs.getLong(MoteurDaoSqlEnum.prefix.getSql()+MoteurDaoFieldEnum.id.name());
				String mmarque = rs.getString(MoteurDaoSqlEnum.prefix.getSql()+MoteurDaoFieldEnum.marque.name());
				String mmodele = rs.getString(MoteurDaoSqlEnum.prefix.getSql()+MoteurDaoFieldEnum.modele.name());
				int mcyl = rs.getInt(MoteurDaoSqlEnum.prefix.getSql()+MoteurDaoFieldEnum.cylindree.name());
				Moteur moteur = new Moteur(mid,mmarque,mmodele,mcyl);
				
				
				list.add(new Voiture(vid,vmarque,vmodele,frein,moteur));
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
	public Voiture updateById(Voiture pT) throws DaoException {
		if (pT == null) {
			throw new DaoException(DaoExceptionEnum.BadParameter.getText());
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = cnx.prepareStatement(VoitureDaoSqlEnum.update.getSql());
			st.setString(1, pT.getMarque());
			st.setString(2, pT.getModele());
			st.setLong(3, pT.getMoteur().getId());
			st.setLong(4, pT.getFrein().getId());
			st.setLong(5, pT.getId());
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
			PreparedStatement st = cnx.prepareStatement(VoitureDaoSqlEnum.delete.getSql());
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
