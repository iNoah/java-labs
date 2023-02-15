package a00123456.util;

import java.util.Comparator;
import a00123456.data.Player;

public class CompareByBirthdate implements Comparator<Player> {
	
	public int compare (Player p1, Player p2){
		
		return p1.getBirthDate().getYear() - p2.getBirthDate().getYear();
	}
	
	

}
