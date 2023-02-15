/**
 * Project: A00123456Lab2
 * File: PlayerReader.java
 * Date: Sep 26, 2015
 * Time: 7:02:47 PM
 */

package a00123456;

/**
 * @author iNoah, A00123456
 *
 */
public class PlayerReader {

	/**
	 * Read player.
	 *
	 * @param args
	 *            the arguments
	 * @return the player[]
	 */
	public Player[] readPlayer(String[] args) {
		String[] s1 = args[0].split("\\:");
		Player[] players = new Player[s1.length];
		for (int i = 0; i < s1.length; i++) {
			String[] s2 = s1[i].split("\\|");
			players[i] = new Player(s2[0], s2[1], s2[2], s2[3], s2[4]);
		}
		return players;
	}

}
