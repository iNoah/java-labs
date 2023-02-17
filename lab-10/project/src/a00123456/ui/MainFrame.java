package a00123456.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import a00123456.data.Database;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// MainFrame frame = new MainFrame();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public MainFrame() {

		setTitle("Lab 10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmExit.setMnemonic('E');
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Lab 10\nBy iNoah, A00123456", "About Lab 10", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAbout.setMnemonic('A');
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					ListModel model = list.getModel();

					try {
						PlayerDialog dialog = null;
						for (int index : list.getSelectedIndices()) {
							dialog = new PlayerDialog(model.getElementAt(index));
						}
						// PlayerDialog dialog = new PlayerDialog();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		contentPane.add(list, BorderLayout.CENTER);
		try {
			Connection connection = Database.getConnection();
			Statement statement = connection.createStatement();
			String sqlString = "SELECT * FROM Players";
			ResultSet resultSet = statement.executeQuery(sqlString);

			MyListModel lm = new MyListModel();
			while (resultSet.next()) {
				String name = resultSet.getString("id") + " " + resultSet.getString("firstName") + " " + resultSet.getString("lastName") + " " + resultSet.getString("emailAddress")
						+ " " + resultSet.getString("gamerTag") + " " + resultSet.getString("birthDate");
				lm.addElement(name);
			}
			list.setModel(lm);

			statement.close();
			resultSet.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("rawtypes")
	class MyListModel extends AbstractListModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final ArrayList<String> myArrayList = new ArrayList<>();

		public void addElement(String name) {
			myArrayList.add(name);
			fireIntervalAdded(this, myArrayList.size() - 1, myArrayList.size() - 1);
		}

		@Override
		public Object getElementAt(int arg0) {
			// TODO Auto-generated method stub
			return myArrayList.get(arg0);
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return myArrayList.size();
		}

	}

}
