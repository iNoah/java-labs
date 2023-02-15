/**
 * Project: A00123456Lab3
 * File: Lab3.java
 * Date: Oct 5, 2015
 * Time: 8:42:47 AM
 */

package a00123456;

import java.text.ParseException;

import a00123456.io.PlayerReader;
import a00123456.io.PlayerReport;

/**
 * @author iNoah, A00123456
 *
 */
public class Lab3 {
	public static final int NO_COMMANDLINE_ARGUMENT = 0;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		PlayerReader reader = new PlayerReader();
		PlayerReport reporter = new PlayerReport();
		if (args.length == NO_COMMANDLINE_ARGUMENT) {
			System.out.println("Usage java -jar A00123456Lab3.jar <input string>");
			System.exit(-1);
		} else {
			try {
				reporter.printReport(reader.readPlayer(args));
			} catch (ApplicationException ae) {
				ae.printStackTrace();
			}
			System.exit(0);
		}
	}

}
