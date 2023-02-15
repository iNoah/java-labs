/**
 * Project: A00123456Lab5
 * File: PlayerReport.java
 */

package a00123456.player.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;

import a00123456.data.Player;

/**
 * Prints a formated Players report.
 * 
 * @author iNoah, A00123456
 *
 */
public class PlayerReport {
	private static final Logger LOG = Logger.getLogger(PlayerReport.class);

	public static final String SEPERATOR = "-------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-24s %-24s %-15s%n";
	public static final String PERSONA_FORMAT = "%3d. %06d %-12s %-12s %-24s %-24s %-15s%n";
	public static final DateTimeFormatter dateTimeForatter = DateTimeFormatter.ofPattern("E dd MMM uuuu");

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
	public static void write(List<Player> players) {
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("players_report.txt", true);
			ps = new PrintStream(fos);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		if (ps != null) {
			System.setOut(ps);
		}
		System.out.println("Personas Report");
		System.out.println(SEPERATOR);
		System.out.format(HEADER_FORMAT, "# ", "ID", "First name", "Last name", "Email", "Gamer tag", "Birthdate").toString();
		System.out.println(SEPERATOR);
		int i = 0;
		for (Player player : players) {
			LocalDateTime date = player.getBirthDate();
			System.out.format(PERSONA_FORMAT, ++i, player.getId(), player.getFirstName(), player.getLastName(), player.getEmailAddress(), player.getGamerTag(),
					dateTimeForatter.format(date)).toString();
		}

	}
}
