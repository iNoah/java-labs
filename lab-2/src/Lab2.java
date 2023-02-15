/**
 * Project: A00123456Lab2
 * File: Lab2.java
 * Date: Sep 27, 2015
 * Time: 8:42:47 AM
 */

package a00123456;

/**
 * @author iNoah, A00123456
 *
 */
public class Lab2 {
	public static final int NO_COMMANDLINE_ARGUMENT = 0;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		PlayerReader reader = new PlayerReader();
		PlayerReport reporter = new PlayerReport();
		if (args.length == NO_COMMANDLINE_ARGUMENT) {
			System.out.println("Usage java -jar A00123456Lab2.jar <input string>");
			System.exit(-1);
		} else {
			reporter.printReport(reader.readPlayer(args));
			System.exit(0);
		}
	}

}
