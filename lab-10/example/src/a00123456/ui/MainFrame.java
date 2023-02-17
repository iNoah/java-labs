/**
 * Project: A00123456Lab7
 * File: MainFrame.java
 * Date: Oct 21, 2014
 * Time: 5:56:20 PM
 */

package a00123456.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import a00123456.dao.PlayerDao;
import a00123456.data.Player;

/**
 * @author Fred Fish, A00123456
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private static Logger LOG = Logger.getLogger(MainFrame.class);

	private PlayerDao playerDao;
	private JList<PlayerListItem> playersList;
	private PlayerListModel playerModel;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public MainFrame() throws SQLException {
		super("Lab 10");

		playerDao = new PlayerDao();
		playerModel = new PlayerListModel();

		setBounds(100, 100, 800, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Lab 9\nBy Fred Fish, A001234567", "Lab 9",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);

		playersList = new JList<PlayerListItem>(playerModel);
		playersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(new JScrollPane(playersList));

		playersList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (event.getValueIsAdjusting()) {
					return;
				}
				PlayerListItem player = playersList.getSelectedValue();
				if (player != null) {
					showPlayerDetails(player, playersList.getSelectedIndex());
				}
			}
		});

		// set the data
		try {
			playerModel.setPlayers(playerDao.getPlayers());
		} catch (Exception e) {
			LOG.equals(e.getMessage());
		}
	}

	protected void showPlayerDetails(PlayerListItem item, int index) {
		try {
			PlayerDialog dialog = new PlayerDialog(item.getPlayer());
			dialog.setVisible(true);
			Player player = dialog.getPlayer();
			if (player != null) {
				playerDao.update(player);
				playerModel.setElementAt(player, index);
			}

			playersList.clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
