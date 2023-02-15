/**
 * Project: A00123456Lab4
 * File: PlayerReport.java
 * Date: Oct 11, 2015
 * Time: 6:56:53 PM
 */

package a00123456.io;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

import a00123456.ApplicationException;
import a00123456.data.Player;
import a00123456.util.CompareByBirthdate;
import a00123456.util.Validator;

/**
 * The Class PlayerReport.
 *
 * @author iNoah, A00123456
 */
public class PlayerReport {
	private Formatter f = new Formatter(System.out);
	private Validator v = new Validator();
	private SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy");

	/**
	 * Prints the report.
	 *
	 * @param players
	 *            the Player ArrayList which need to be printed
	 */
	public void printReport(ArrayList<Player> players) {
		f.format("Players Report\n");
		f.format("---------------------------------------------------------------------------------------------------------------------\n");
		f.format("%-2s. %-6s %-15s %-15s %-30s %-20s %-20s%n", "# ", "ID", "First Name", "Last Name", "Email", "Gamertag", "Birthdate");
		f.format("---------------------------------------------------------------------------------------------------------------------\n");
		Collections.sort(players, new CompareByBirthdate());
		int i = 0;
		try {
			for (Player p : players) {
				f.format("%-2d. %06d %-15s %-15s %-30s %-20s %-20s%n", ++i, p.getId(), p.getFirstName(), p.getLastName(), v.validateEmail(p.getEmail()), p.getGamertag(),
						format.format(p.getBirthDate().getTime()));
			}
		} catch (ApplicationException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}
}
