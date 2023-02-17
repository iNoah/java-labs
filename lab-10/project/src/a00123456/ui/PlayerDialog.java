package a00123456.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PlayerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblNewLabel;
	private JLabel lblGamertag;
	private JLabel lblBirthDate;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// try {
	// PlayerDialog dialog = new PlayerDialog();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public PlayerDialog(Object o) {
		String s = o.toString();
		String[] fields = s.split(" ");
		setTitle("Player");
		// Random r = new Random();
		// Player player = players.get(r.nextInt(players.size()));
		setBounds(100, 100, 562, 407);
		getContentPane().setLayout(new MigLayout("", "[300][544px,grow]", "[35px][35][35][35][35][35][35][40][]"));
		{
			lblId = new JLabel("ID");
			getContentPane().add(lblId, "cell 0 1,alignx trailing");
		}
		{
			textField = new JTextField(fields[0]);
			textField.setEditable(false);
			textField.setBackground(Color.LIGHT_GRAY);
			getContentPane().add(textField, "cell 1 1,growx");
			textField.setColumns(10);
		}
		{
			lblFirstName = new JLabel("First Name");
			getContentPane().add(lblFirstName, "cell 0 2,alignx trailing");
		}
		{
			textField_1 = new JTextField(fields[1]);
			getContentPane().add(textField_1, "cell 1 2,growx");
			textField_1.setColumns(10);
		}
		{
			lblLastName = new JLabel("Last Name");
			getContentPane().add(lblLastName, "cell 0 3,alignx trailing");
		}
		{
			textField_2 = new JTextField(fields[2]);
			getContentPane().add(textField_2, "cell 1 3,growx");
			textField_2.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("Email Address");
			getContentPane().add(lblNewLabel, "cell 0 4,alignx trailing");
		}
		{
			textField_3 = new JTextField(fields[3]);
			getContentPane().add(textField_3, "cell 1 4,growx");
			textField_3.setColumns(10);
		}
		{
			lblGamertag = new JLabel("Gamertag");
			getContentPane().add(lblGamertag, "cell 0 5,alignx trailing");
		}
		{
			textField_4 = new JTextField(fields[4]);
			getContentPane().add(textField_4, "cell 1 5,growx");
			textField_4.setColumns(10);
		}
		{
			lblBirthDate = new JLabel("Birthdate");
			getContentPane().add(lblBirthDate, "cell 0 6,alignx trailing");
		}
		{
			textField_5 = new JTextField(fields[5]);
			getContentPane().add(textField_5, "cell 1 6,growx");
			textField_5.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 1 8,growx,aligny top");
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
