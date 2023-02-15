/**
 * Project: A00123456Lab3
 * File: PlayerReport.java
 * Date: Oct 5, 2015
 * Time: 6:56:53 PM
 */

package a00123456.io;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Formatter;

import a00123456.ApplicationException;
import a00123456.data.Player;
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
	 * @param p
	 *            the Player array which need to be printed
	 */
	public void printReport(Player[] p) {
		Instant start = Instant.now();
		System.out.println("\n" + start.toString());
		f.format("%-20s%n", "Players Report");
		f.format("--------------------------------------------------------------------------------------------------------------------------\n");
		f.format("%-2s %-6s %-20s %-20s %-30s %-20s %-20s%n", "#.", "ID", "First Name", "Last Name", "Email", "Gamertag", "Birthdate");
		f.format("--------------------------------------------------------------------------------------------------------------------------\n");
		try {
			for (int i = 0; i < p.length; i++) {
				f.format("%-2s %-6s %-20s %-20s %-30s %-20s %-20s%n", p[i].getId() + ".", "00000" + p[i].getId(), p[i].getFirstName(), p[i].getLastName(),
						v.validateEmail(p[i].getEmail()), p[i].getGamertag(), format.format(p[i].getBirthDate().getTime()));
			}
		} catch (ApplicationException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		Instant end = Instant.now();
		System.out.println("\n" + end.toString());
		long ms = Duration.between(start, end).toMillis();
		System.out.println("Duration: " + ms + " ms");
	}
}
