/**
 * Project: A00123456Lab7
 * File: PlayerDAO.java
 * Date: Nov 3, 2015
 * Time: 2:46:36 PM
 */

package a00123456.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import a00123456.data.Player;
import a00123456.database.Database;

/**
 * @author iNoah, A00123456
 *
 */
public class PlayerDao extends Dao {
	private static final Logger LOG = Logger.getLogger(PlayerDaoTester.class.getName());
	public static final String TABLE_NAME = "Players";
	public static final String PLAYERID = "PLAYERID";
	public static final String FIRSTNAME = "FIRSTNAME";

	public static final String LASTNAME = "LASTNAME";
	public static final String GAMERTAG = "GAMERTAG";
	public static final String EMAIL = "EMAIL";
	public static final String BIRTHDATE = "BIRTHDATE";

	public PlayerDao(Database database) {
		super(database, TABLE_NAME);
	}

	@Override
	public void create() throws SQLException {
		String createStatement = String.format("create table %s(%s VARCHAR(9), %s VARCHAR(15), %s VARCHAR(15), %s VARCHAR(25), %s VARCHAR(15), %s VARCHAR(15), primary key (%s) )",
				_tableName, PLAYERID, FIRSTNAME, LASTNAME, EMAIL, GAMERTAG, BIRTHDATE, PLAYERID);
		super.create(createStatement);
	}

	public void add(Player player) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = _database.getConnection();
			statement = connection.createStatement();
			String insertString = String.format("insert into %s values ('%d', '%s', '%s', '%s', '%s', '%s')", _tableName, //
					player.getId(), player.getFirstName(), player.getLastName(), player.getEmailAddress(), player.getGamerTag(), player.getBirthDate().toString().substring(0, 10));
			statement.executeUpdate(insertString);
			System.out.println(insertString);
		} finally {
			close(statement);
		}
	}

	public Player readById(int id) throws SQLException, Exception {
		Connection connection;
		Statement statement = null;
		Player player = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT * FROM %s WHERE %d = '%d'", _tableName, PLAYERID, id);
			ResultSet resultSet = statement.executeQuery(sqlString);

			// get the player
			// throw an exception if we get more than one result
			int count = 0;
			while (resultSet.next()) {
				count++;
				if (count > 1) {
					throw new Exception(String.format("Expected one result, got %d", count));
				}
				player = new Player();
				player.setId(resultSet.getInt(PLAYERID));
				player.setFirstName(resultSet.getString(FIRSTNAME));

				player.setLastName(resultSet.getString(LASTNAME));
				player.setEmailAddress(resultSet.getString(EMAIL));
				player.setGamerTag(resultSet.getString(GAMERTAG));

				player.setBirthDate(Integer.parseInt(resultSet.getString(BIRTHDATE).substring(0, 4)), Integer.parseInt(resultSet.getString(BIRTHDATE).substring(4, 6)) - 1,
						Integer.parseInt(resultSet.getString(BIRTHDATE).substring(6, 8)));

			}
		} finally {
			close(statement);
		}

		return player;
	}

	public void update(Player player) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("UPDATE %s set %d='%d', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE %d='%d'", _tableName, //
					PLAYERID, player.getId(), //
					FIRSTNAME, player.getFirstName(), //
					LASTNAME, player.getLastName(), //
					EMAIL, player.getEmailAddress(), //
					GAMERTAG, player.getGamerTag(), BIRTHDATE, player.getBirthDate(), //

			PLAYERID, player.getId());
			System.out.println(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			System.out.println(String.format("Updated %d rows", rowcount));
		} finally {
			close(statement);
		}
	}

	public void delete(Player player) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("DELETE from %s WHERE %d='%d'", _tableName, PLAYERID, player.getId());
			System.out.println(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			System.out.println(String.format("Deleted %d rows", rowcount));
		} finally {
			close(statement);
		}
	}

	public List<String> getGamerTags() throws SQLException {
		List<String> gamertags = new ArrayList<>();
		Connection connection;
		Statement statement = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			for (int i = 1; i <= 5; i++) {
				String sqlString = String.format("SELECT %s from %s WHERE %d='%d'", GAMERTAG, _tableName, PLAYERID, i);
				// ResultSet resultSet = statement.executeQuery(sqlString);

				gamertags.add(sqlString);
			}
		} finally {
			close(statement);
		}
		return gamertags;
	}

	public Player getPlayer(String gamertag) throws SQLException, Exception {
		Connection connection;
		Statement statement = null;
		Player player = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT * FROM %s WHERE %s = '%s'", _tableName, GAMERTAG, gamertag);
			ResultSet resultSet = statement.executeQuery(sqlString);
			LOG.debug(sqlString);
			// get the player
			// throw an exception if we get more than one result
			int count = 0;
			while (resultSet.next()) {
				count++;
				if (count > 1) {
					throw new Exception(String.format("Expected one result, got %d", count));
				}
				player = new Player();
				player.setId(resultSet.getInt(PLAYERID));
				player.setFirstName(resultSet.getString(FIRSTNAME));

				player.setLastName(resultSet.getString(LASTNAME));
				player.setEmailAddress(resultSet.getString(EMAIL));
				player.setGamerTag(resultSet.getString(GAMERTAG));

				player.setBirthDate(Integer.parseInt(resultSet.getString(BIRTHDATE).substring(0, 4)), Integer.parseInt(resultSet.getString(BIRTHDATE).substring(4, 6)) - 1,
						Integer.parseInt(resultSet.getString(BIRTHDATE).substring(6, 8)));

			}
		} finally {
			close(statement);
		}

		return player;
	}
}
