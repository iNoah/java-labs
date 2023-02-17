/**
 * Project: A00123456Lab7
 * File: Lab2.java
 * Date: Sep 14, 2014
 * Time: 3:00:38 PM
 */

package a00123456;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00123456.dao.PlayerDao;
import a00123456.data.Database;
import a00123456.data.Player;
import a00123456.player.io.PlayerReader;
import a00123456.ui.MainFrame;

/**
 * To demonstrate knowledge of JDBC
 * 
 * @author iNoah, A00123456
 *
 */
public class Lab10 {

	private static final String PLAYERS_DATA_FILENAME = "players.txt";

	private static final Logger LOG = LogManager.getLogger(Lab10.class);
	private static PlayerDao playerDao;
	private File playerDataFile;

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File(PLAYERS_DATA_FILENAME);
		if (!file.exists()) {
			System.out.format("Required '%s' is missing.", PLAYERS_DATA_FILENAME);
			System.exit(-1);
		}

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
		new Lab10(file).run();
		createUI();

	}

	/**
	 * Lab7 constructor. Initialized the players collection.
	 */
	public Lab10(File playerDataFile) {
		this.playerDataFile = playerDataFile;
	}

	private static void createUI() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Populate the players and print them out.
	 */
	private void run() {
		try {
			loadPlayers();
			// PlayerDaoTester tester = new PlayerDaoTester(playerDao);
			// tester.test();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void loadPlayers() throws IOException, SQLException, ApplicationException {
		playerDao = new PlayerDao();
		if (!Database.tableExists(PlayerDao.TABLE_NAME)) {
			int playerCount = 0;
			playerDao.create();
			List<Player> players = PlayerReader.read(playerDataFile);
			for (Player player : players) {
				playerDao.add(player);
				playerCount++;
			}

			LOG.debug("Inserted " + playerCount + " players");
		}
	}

}
