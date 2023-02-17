/**
 * Project: A00123456Lab8
 * File: Dao.java
 * Date: Nov 3, 2014
 * Time: 10:40:28 PM
 */

package a00123456.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import a00123456.data.Database;

/**
 * @author Fred Fish, A00123456
 *
 */
public abstract class Dao {
	private static Logger LOG = Logger.getLogger(Dao.class);
	protected final String tableName;
	private Database database;

	protected Dao(String tableName) {
		database = Database.getTheInstance();
		this.tableName = tableName;
	}

	public abstract void create() throws SQLException;

	/**
	 * Delete the database table
	 * 
	 * @throws SQLException
	 */
	public void drop() throws SQLException {
		Statement statement = null;
		try {
			
			Connection connection = database.getConnection();
			statement = connection.createStatement();
			if (database.tableExists(tableName)) {
				statement.executeUpdate("drop table " + tableName);
			}
		} finally {
			close(statement);
		}
	}

	/**
	 * Tell the database we're shutting down.
	 */
	public void shutdown() {
		database.shutdown();
		LOG.debug("database shutdown");
	}

	protected void create(String createStatement) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = database.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(createStatement);
		} finally {
			close(statement);
		}
	}

	protected int add(String updateStatement) throws SQLException {
		int row = -1;
		Statement statement = null;
		try {
			Connection connection = database.getConnection();
			statement = connection.createStatement();
			row = statement.executeUpdate(updateStatement);
		} finally {
			close(statement);
		}

		return row;
	}

	protected void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			LOG.error("Failed to close statment" + e);
		}
	}

}
