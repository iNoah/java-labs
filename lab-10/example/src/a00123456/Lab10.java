/**
 * Project: A00123456Lab10
 * File: Lab10.java
 */

package a00123456;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00123456.dao.PlayerDao;
import a00123456.data.Database;
import a00123456.data.Player;
import a00123456.player.io.PlayerReader;
import a00123456.ui.MainFrame;

/**
 * Singletons!
 * 
 * @author Fred Fish, A00123456
 *
 */
public class Lab10 {

	private static final String PLAYERS_DATA_FILENAME = "players.txt";
	private static final String LOG_PROPERTIES_FILENAME = "log.properties";
	private static final String DB_PROPERTIES_FILENAME = "db.properties";
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	private static Logger LOG = Logger.getLogger(Lab10.class);
	private File playerDataFile;

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties logProperties = new Properties();
		logProperties.load(new FileInputStream(LOG_PROPERTIES_FILENAME));
		PropertyConfigurator.configure(logProperties);
		LOG.info(dateFormat.format(new Date()));
		File file = new File(PLAYERS_DATA_FILENAME);
		if (!file.exists()) {
			System.out.format("Required '%s' is missing.", PLAYERS_DATA_FILENAME);
			System.exit(-1);
		}

		new Lab10(file).run();
		LOG.info(dateFormat.format(new Date()));
	}

	/**
	 * Lab7 constructor. Initialized the players collection.
	 */
	public Lab10(File playerDataFile) {
		this.playerDataFile = playerDataFile;
	}

	/**
	 * Populate the players and print them out.
	 */
	private void run() {
		try {
			loadPlayers();
			createUI();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void loadPlayers() throws IOException, SQLException, ApplicationException {
		Properties dbProperties = new Properties();
		dbProperties.load(new FileInputStream(DB_PROPERTIES_FILENAME));
		
		Database db = Database.getTheInstance();
		db.init(dbProperties);
		
		if (!db.tableExists(PlayerDao.TABLE_NAME)) {
			int playerCount = 0;
			PlayerDao playerDao = new PlayerDao();
			playerDao.create();
			List<Player> players = PlayerReader.read(playerDataFile);
			for (Player player : players) {
				playerDao.add(player);
				playerCount++;
			}

			LOG.debug("Inserted " + playerCount + " players");
		}
	}

	private void setLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, use the default.
		}

	}

	public void createUI() {
		setLookAndFeel();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
