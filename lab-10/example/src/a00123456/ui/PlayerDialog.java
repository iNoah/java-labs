/**
 * Project: A00123456Lab7
 * File: PlayerDialog.java
 */

package a00123456.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import a00123456.data.Player;

/**
 * @author Fred Fish, A00123456
 *
 */
@SuppressWarnings("serial")
public class PlayerDialog extends JDialog {

	public static final DateFormat birthDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField firsNameField;
	private JTextField lastNameField;
	private JTextField emailAddressField;
	private JTextField gamertagField;
	private JTextField birthdateField;

	/**
	 * Create the dialog.
	 * 
	 * @param player
	 */
	public PlayerDialog(Player player) {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		{
			JLabel lblId = new JLabel("ID");
			contentPanel.add(lblId, "cell 0 0,alignx trailing");
		}
		{
			idField = new JTextField();
			idField.setEnabled(false);
			idField.setEditable(false);
			contentPanel.add(idField, "cell 1 0,growx");
			idField.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First Name");
			contentPanel.add(lblFirstName, "cell 0 1,alignx trailing");
		}
		{
			firsNameField = new JTextField();
			contentPanel.add(firsNameField, "cell 1 1,growx");
			firsNameField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			contentPanel.add(lblLastName, "cell 0 2,alignx trailing");
		}
		{
			lastNameField = new JTextField();
			contentPanel.add(lastNameField, "cell 1 2,growx");
			lastNameField.setColumns(10);
		}
		{
			JLabel lblEmailAddress = new JLabel("Email Address");
			contentPanel.add(lblEmailAddress, "cell 0 3,alignx trailing");
		}
		{
			emailAddressField = new JTextField();
			contentPanel.add(emailAddressField, "cell 1 3,growx");
			emailAddressField.setColumns(10);
		}
		{
			JLabel lblGamertag = new JLabel("Gamertag");
			contentPanel.add(lblGamertag, "cell 0 4,alignx trailing");
		}
		{
			gamertagField = new JTextField();
			contentPanel.add(gamertagField, "cell 1 4,growx");
			gamertagField.setColumns(10);
		}
		{
			JLabel lblBirthdate = new JLabel("Birthdate");
			contentPanel.add(lblBirthdate, "cell 0 5,alignx trailing");
		}
		{
			birthdateField = new JTextField();
			contentPanel.add(birthdateField, "cell 1 5,growx");
			birthdateField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PlayerDialog.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PlayerDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		setFields(player);
	}

	/**
	 * @param player
	 */
	private void setFields(Player player) {
		idField.setText(Integer.toString(player.getId()));
		firsNameField.setText(player.getFirstName());
		lastNameField.setText(player.getLastName());
		emailAddressField.setText(player.getEmailAddress());
		gamertagField.setText(player.getGamerTag());
		birthdateField.setText(birthDateFormat.format(player.getBirthDate().getTime()));
	}

	/**
	 * @return
	 */
	public Player getPlayer() {
		Player player = new Player();
		player.setId(Integer.parseInt(idField.getText()));
		player.setFirstName(firsNameField.getText());
		player.setLastName(lastNameField.getText());
		player.setEmailAddress(emailAddressField.getText());
		player.setGamerTag(gamertagField.getText());
		// warning, there should be validation and verification on this birthdate field
		String birthdateString = birthdateField.getText();
		String[] birthdateElements = birthdateString.split("-");
		player.setBirthDate(Integer.parseInt(birthdateElements[0]), Integer.parseInt(birthdateElements[1]), Integer.parseInt(birthdateElements[2]));
		
		return player;
	}

}
