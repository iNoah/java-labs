/**
 * Project: A00123456Lab4
 * File: PlayerReader.java
 * Date: Oct 11, 2015
 * Time: 7:02:47 PM
 */

package a00123456.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import a00123456.ApplicationException;
import a00123456.data.Player;

/**
 * @author iNoah, A00123456
 *
 */
public class PlayerReader {

	/**
	 * Read player.
	 *
	 * @param args
	 *            the argument
	 * @return the player ArrayList
	 * @throws ParseException
	 *             the parse exception
	 * @throws ApplicationException
	 *             the application exception
	 */
	public ArrayList<Player> readPlayer(String[] args) throws ParseException, ApplicationException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		String[] s1 = args[0].split("\\:");

		ArrayList<Player> players = new ArrayList<>();

		for (int i = 0; i < s1.length; i++) {
			String[] s2 = s1[i].split("\\|");
			if (s2.length < 6) {
				throw new ApplicationException("Expected 6 elements but got " + s2.length);
			}
			java.util.Date birthDate = formatter.parse(s2[5]);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(birthDate);
			players.add(new Player(Integer.parseInt(s2[0]), s2[1], s2[2], s2[3], s2[4], gc));
		}

		return players;
	}

}
