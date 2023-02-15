/**
 * Project: A00123456Lab4
 * File: PlayerReport.java
 */

package a00123456.player.io;

import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import a00123456.data.Player;

/**
 * Prints a formated Players report.
 * 
 * @author iNoah, A00123456
 *
 */
public class PlayerReport {

	public static final String SEPERATOR = "-------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-24s %-24s %-15s%n";
	public static final String PERSONA_FORMAT = "%3d. %06d %-12s %-12s %-24s %-24s %-15s%n";
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");

	/**
	 * private constructor to prevent instantiation
	 */
	private PlayerReport() {
	}

	/**
	 * Print the report.
	 * 
	 * @param players
	 */
	public static void write(List<Player> players, PrintStream out) {
		out.println("Personas Report");
		out.println(SEPERATOR);
		out.format(HEADER_FORMAT, "# ", "ID", "First name", "Last name", "Email", "Gamer tag", "Birthdate");
		out.println(SEPERATOR);

		int i = 0;
		for (Player player : players) {
			ZonedDateTime date = player.getBirthDate();
			out.format(PERSONA_FORMAT, ++i, player.getId(), player.getFirstName(),
					player.getLastName(), player.getEmailAddress(), player.getGamerTag(), date.format(DATE_FORMAT));
		}
	}
}
