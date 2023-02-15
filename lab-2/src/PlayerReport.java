/**
 * Project: A00123456Lab2
 * File: PlayerReport.java
 * Date: Sep 26, 2015
 * Time: 6:56:53 PM
 */

package a00123456;

import java.util.Formatter;

/**
 * The Class PlayerReport.
 *
 * @author iNoah, A00123456
 */
public class PlayerReport {

	private Formatter f = new Formatter(System.out);

	private Validator v = new Validator();

	/**
	 * Prints the report.
	 *
	 * @param p
	 *            the Player array which need to be printed
	 */
	public void printReport(Player[] p) {
		f.format("%n%-20s%n", "Players Report");
		f.format("%-100s%n", "-------------------------------------------------------------------------------------------------------------");
		f.format("%-2s %-6s %-20s %-20s %-30s %-20s%n", "#.", "ID", "First Name", "Last Name", "Email", "Gamertag");
		f.format("%-100s%n", "-------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < p.length; i++) {
			f.format("%-2s %-6s %-20s %-20s %-30s %-20s%n", p[i].getId() + ".", "00000" + p[i].getId(), p[i].getFirstName(), p[i].getLastName(), v.validateEmail(p[i].getEmail()),
					p[i].getGamertag());

		}

	}
}
