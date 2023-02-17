/**
 * Project: A00123456Lab7
 * File: PlayerDaoTester.java
 * Date: Feb 21, 2015
 * Time: 7:28:45 PM
 */

package a00123456;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00123456.dao.PlayerDao;
import a00123456.data.Player;

/**
 * @author iNoah, A00123456
 *
 */
public class PlayerDaoTester {
	
	private static Logger LOG = LogManager.getLogger(PlayerDaoTester.class);
	private PlayerDao playerDao;
	
	public PlayerDaoTester(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public void test() {
		try {
			List<String> gamertags = playerDao.getGamertags();
			for (String gamertag : gamertags) {
				LOG.info(gamertag);
				Player player = playerDao.getPlayer(gamertag);
				LOG.info(player);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
	}

}
