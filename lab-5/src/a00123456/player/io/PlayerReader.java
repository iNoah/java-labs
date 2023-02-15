/**
 * Project: A00123456Lab5
 * File: PlayerReader.java
 */

package a00123456.player.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00123456.ApplicationException;
import a00123456.data.Player;
import a00123456.util.Validator;

/**
 * Read the player input.
 * 
 * @author iNoah, A00123456
 *
 */
public class PlayerReader {

	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";
	private static final Logger LOG = Logger.getLogger(PlayerReader.class);

	/**
	 * private constructor to prevent instantiation
	 */
	private PlayerReader() {
	}

	/**
	 * Read the player input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return A list of players.
	 * @throws ApplicationException
	 */
	public static List<Player> read(String data) throws ApplicationException {
		PropertyConfigurator.configure("log.properties");
		String[] rows = data.split(RECORD_DELIMITER);
		List<Player> players = new ArrayList<>();
		for (String row : rows) {
			String[] elements = row.split(FIELD_DELIMITER);
			if (elements.length != Player.ATTRIBUTE_COUNT) {
				throw new ApplicationException(String.format("Expected %d but got %d: %s", Player.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements)));
			}

			Player player = new Player();
			int index = 0;
			player.setId(Integer.parseInt(elements[index++]));
			player.setFirstName(elements[index++]);
			player.setLastName(elements[index++]);
			String email = elements[index++];
			if (!Validator.validateEmail(email)) {
				throw new ApplicationException(String.format("Invalid email: %s", email));
			}
			player.setEmailAddress(email);
			player.setGamerTag(elements[index++]);

			String yyyymmdd = elements[index];
			try {
				player.setBirthDate(Integer.parseInt(yyyymmdd.substring(0, 4)), Integer.parseInt(yyyymmdd.substring(4, 6)) - 1, Integer.parseInt(yyyymmdd.substring(6, 8)));
			} catch (NumberFormatException e) {
				LOG.error("Invalid date element:" + yyyymmdd);
			}

			players.add(player);
		}

		return players;
	}

}
