/**
 * Project: A00123456Lab5
 * File: Lab2.java
 * Date: Sep 14, 2014
 * Time: 3:00:38 PM
 */

package a00123456;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00123456.data.Player;
import a00123456.database.Database;
import a00123456.database.dao.PlayerDao;
import a00123456.player.io.PlayerReader;

/**
 * To demonstrate knowledge of File IO and (log4j) Logging
 * 
 * Create a commandline program which reads player data, creates Player objects, adds them to a collection, and prints
 * a simple Player report sorted by birthdate
 * 
 * @author iNoah, A00123456
 *
 */
public class Lab7 {
	public static final String DB_PROPERTIES_FILENAME = "db.properties";
	private static final String PERSONAS_DATA_FILENAME = "players.txt";
	private static final Logger LOG = Logger.getLogger(Lab7.class.getName());

	private static Database database;
	private PlayerDao playerDao;
	// private PlayerDaoTester playerDaoTester;

	private final Properties dbProperties;
	private Connection connection;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log.properties");
		File dbPropertiesFile = new File(DB_PROPERTIES_FILENAME);
		if (!dbPropertiesFile.exists()) {
			showUsage();
			System.exit(-1);
		}

		try {
			Lab7 demo = new Lab7(dbPropertiesFile);
			demo.run();

		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			database.shutdown();
		}

	}

	private static void showUsage() {
		LOG.info("The database properties filename must be passed in the commandline.");
	}

	private Lab7(File dbPropertiesFile) throws IOException {
		dbProperties = new Properties();
		dbProperties.load(new FileReader(dbPropertiesFile));

		database = new Database(dbProperties);
	}

	private void run() throws Exception {
		connection = database.getConnection();
		playerDao = new PlayerDao(database);

		try {
			// drop the tables if they exist
			dropTables();

			// create the tables
			createTables();

			insertPlayers();

			for (String s : playerDao.getGamerTags()) {
				System.out.println(playerDao.getPlayer(s));
				LOG.info(playerDao.getPlayer(s));
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			connection.close();
		}
	}

	/*
	 * private void delete(Player player) {
	 * try {
	 * playerDao.delete(player);
	 * } catch (Exception e) {
	 * System.out.println(e.getMessage());
	 * }
	 * }
	 */

	/*
	 * private Player readStudent() {
	 * Player player = null;
	 * try {
	 * player = PlayerDao.readById(444111120);
	 * } catch (Exception e) {
	 * System.out.println(e.getMessage());
	 * }
	 * return player;
	 * }
	 */

	/*
	 * private void update(Player player) {
	 * try {
	 * playerDao.update(player);
	 * } catch (Exception e) {
	 * System.out.println(e.getMessage());
	 * }
	 * }
	 */

	private void dropTables() throws SQLException {
		playerDao.drop();

	}

	private void createTables() throws SQLException {
		playerDao.create();

	}

	private void insertPlayers() throws SQLException {

		/*
		 * Statement statement = _connection.createStatement();
		 * String insertString;
		 */

		try {
			for (Player player : PlayerReader.read(new File(PERSONAS_DATA_FILENAME))) {

				playerDao.add(player);

				/*
				 * insertString = String.format("%d %s %s %s %s %s", player.getId(), player.getFirstName(), player.getLastName(), player.getEmailAddress(), player.getGamerTag(),
				 * player.getBirthDate());
				 * statement.executeUpdate(insertString);
				 * System.out.println("Inserted " + insertString);
				 */
			}

		} catch (SQLException | ApplicationException e) {
			System.out.println(e);
		}
	}

}
