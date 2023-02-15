/**
 * Project: A00123456Lab4
 * File: CompareByBirthdate.java
 * Date: Oct 11, 2015
 * Time: 9:30:01 PM
 */

package a00123456.util;

import java.util.Comparator;

import a00123456.data.Player;

/**
 * @author iNoah, A00123456
 *
 */
public class CompareByBirthdate implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		return p1.getBirthDate().compareTo(p2.getBirthDate());
	}
}
