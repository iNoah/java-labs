/**
 * Project: A00123456Lab10
 * File: PlayerListItem.java
 * Date: Mar 16, 2015
 * Time: 10:00:39 PM
 */

package a00123456.ui;

import java.text.SimpleDateFormat;

import a00123456.data.Player;

/**
 * @author Fred Fish, A00123456
 *
 */
public class PlayerListItem {
	
	private Player player;
	
	/**
	 * @param player
	 */
	public PlayerListItem(Player player) {
		this.player = player;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		if (player == null) {
			return null;
		}

		String birthdate = "";
		if (player.getBirthDate() != null) {
			birthdate = PlayerListModel.birthDateFormat.format(player.getBirthDate().getTime());
		}
		
		return player.getId() + " " + player.getFirstName() + " " + player.getLastName() + " " + player.getEmailAddress() + " "
				+ player.getGamerTag() + " " +  birthdate;
	}
}
