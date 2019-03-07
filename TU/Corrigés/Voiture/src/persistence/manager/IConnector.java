package persistence.manager;

import java.sql.Connection;

import persistence.exception.DaoException;

public interface IConnector {
	public Connection getConnection() throws DaoException;
	public void close() throws DaoException;
}
