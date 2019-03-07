package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.exception.DaoException;
import persistence.exception.DaoExceptionEnum;
import persistence.manager.JDBCManager;

public abstract class AbstractDAO<T> implements IDAO<T> {
	
	@Override
	public T create(T pT) throws DaoException {
		if (pT == null) {
			return null;
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = getCreateStatement(cnx,pT);
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs != null) {
				while(rs.next()) {
					long id = rs.getLong("GENERATED_KEY");
					setId(pT,id);
				}
				rs.close();
			}
			st.close();
			List<PreparedStatement> subs = getSubCreateStatement(cnx,pT);
			if (subs != null) {
				for (PreparedStatement stsub:subs) {
					stsub.executeUpdate();
					stsub.close();
				}
			}
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
	public T findById(long pId) throws DaoException {
		List<T> list = new ArrayList<>();
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = getOneStatement(cnx,pId);
			ResultSet rs  = st.executeQuery();
			while(rs.next()) {
				list.add(fromResultSet(rs));
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
		list = orderBy(list);
		if (list.size() > 1) {
			throw new DaoException(DaoExceptionEnum.MoreThanOne.getText());
		}
		return list.get(0);
	}

	@Override
	public List<T> findList() throws DaoException {
		List<T> list = new ArrayList<>();
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = getListStatement(cnx);
			ResultSet rs  = st.executeQuery();
			while(rs.next()) {
				list.add(fromResultSet(rs));
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
		
		list = orderBy(list);
		return list;
	}

	@Override
	public T updateById(T pT) throws DaoException {
		if (pT == null) {
			return null;
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			PreparedStatement st = getUpdateStatement(cnx,pT);
			st.executeUpdate();
			st.close();
			List<PreparedStatement> subs = getSubUpdateStatement(cnx,pT);
			if (subs != null) {
				for (PreparedStatement stsub:subs) {
					stsub.executeUpdate();
					stsub.close();
				}
			}
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
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			if (cnx == null) {
				throw new DaoException(DaoExceptionEnum.ConnectionNull.getText());
			}
			List<PreparedStatement> subs = getSubDeleteStatement(cnx,pId);
			if (subs != null) {
				for (PreparedStatement stsub:subs) {
					stsub.executeUpdate();
					stsub.close();
				}
			}
			PreparedStatement st = getDeleteStatement(cnx,pId);
			st.executeUpdate();
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
	
	protected abstract T fromResultSet(ResultSet rs) throws Exception;
	protected abstract PreparedStatement getListStatement(Connection cnx) throws Exception;
	protected abstract PreparedStatement getOneStatement(Connection cnx,long id) throws Exception;
	protected abstract PreparedStatement getCreateStatement(Connection cnx,T pT) throws Exception;
	protected abstract PreparedStatement getUpdateStatement(Connection cnx,T pT) throws Exception;
	protected abstract PreparedStatement getDeleteStatement(Connection cnx,long id) throws Exception;
	protected abstract void setId(T pT,long id) throws Exception;
	protected List<T> orderBy(List<T> list) {
		return list;
	}
	protected List<PreparedStatement> getSubCreateStatement(Connection cnx, T pT) throws Exception {
		return null;
	}
	protected List<PreparedStatement> getSubUpdateStatement(Connection cnx, T pT) throws Exception {
		return null;
	}
	protected List<PreparedStatement> getSubDeleteStatement(Connection cnx, long id) throws Exception {
		return null;
	}
}
