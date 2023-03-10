/**
 * Project: A00123456Lab10
 * File: PlayerListModel.java
 */

package a00123456.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import a00123456.data.Player;

/**
 * @author Fred Fish, A00123456
 *
 */
@SuppressWarnings("serial")
public class PlayerListModel extends AbstractListModel<PlayerListItem> {
	
	public static final DateFormat birthDateFormat = new SimpleDateFormat("EEE yyyy MMM dd");

	private List<PlayerListItem> playerItems;

	public PlayerListModel() {
	}

	public void setPlayers(List<Player> players) {
		playerItems = new ArrayList<>(players.size());
		for (Player player : players) {
			playerItems.add(new PlayerListItem(player));
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return playerItems.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public PlayerListItem getElementAt(int index) {
		return playerItems.get(index);
	}

	/**
	 * @param player
	 * @param index
	 */
	public void setElementAt(Player player, int index) {
		PlayerListItem item = playerItems.get(index);
		item.setPlayer(player);
	}
}
