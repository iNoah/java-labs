/**
 * Project: A00123456Lab4
 * File: CompareByBirthdate.java
 * Date: Oct 6, 2014
 * Time: 9:51:18 PM
 */

package a00123456.player;

import java.util.Comparator;

import a00123456.data.Player;

/**
 * @author Fred Fish, A00123456
 *
 */
public class PlayerSorters {

	public static class CompareByBirthdate implements Comparator<Player> {
		public int compare(Player player1, Player player2) {
			return player1.getBirthDate().compareTo(player2.getBirthDate());
		}
	}
}
