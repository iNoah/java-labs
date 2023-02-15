/**
 * Project: A00123456Lab5
 * File: Lab5.java
 */

package a00123456;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

// import org.apache.log4j.PropertyConfigurator;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00123456.data.Player;
import a00123456.player.io.PlayerReader;
import a00123456.player.io.PlayerReport;
import a00123456.util.CompareByBirthdate;

/**
 * To demonstrate knowledge Generics and Collections
 * 
 * 
 * Create a commandline program which reads persona data, creates Persona objects, adds them to a collection, and prints
 * a simple Persona report sorted by birthdate
 * 
 * 
 * @author iNoah, A00123456
 *
 */
public class Lab5 {
	private static final Logger LOG = Logger.getLogger(Lab5.class);

	private String playerData;
	private List<Player> players;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instant startTime = Instant.now();
		PropertyConfigurator.configure("log.properties");
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("players_report.txt");
			ps = new PrintStream(fos);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		if (ps != null) {
			System.setOut(ps);
		}
		System.out.println(startTime);

		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader("players.txt"));

			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str + ":");
			}

			new Lab5(sb.toString()).run();
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Input data is missing. Expecting persona data.");
			LOG.error(e.getMessage());
			System.exit(-1);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}

		Instant endTime = Instant.now();
		System.out.println(endTime);
		System.out.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis());
		ps.close();
	}

	/**
	 * Lab3 constructor. Initialized the personas collection.
	 */
	public Lab5(String playerData) {
		this.playerData = playerData;
	}

	/**
	 * Populate the personas and print them out.
	 */
	private void run() {
		try {
			loadPlayers();

			// sort the players by birthdate
			// players.sort((e1, e2)->e1.getBirthDate().compareTo(e2.getBirthDate()));
			Collections.sort(players, new CompareByBirthdate());

			displayPlayers();
		} catch (ApplicationException e) {
			LOG.error(e.getMessage());
		}
	}

	private void loadPlayers() throws ApplicationException {
		players = PlayerReader.read(playerData);
	}

	private void displayPlayers() {
		PlayerReport.write(players);
	}

}
