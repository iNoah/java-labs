/**
 * Project: A00123456Lab2
 * File: Validator.java
 * Date: Sep 26, 2015
 * Time: 5:03:59 PM
 */

package a00123456;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author iNoah, A00123456
 *
 */
public class Validator {
	public static final String VALID_EMAIL_REGEX = "[a-zA-z]+@[a-zA-Z_]+\\.[a-zA-Z]{2,6}";
	public static final String INVALID_EMAIL = "N/A";

	/**
	 * Validate email.
	 *
	 * @param email
	 *            the email
	 * 
	 * @return the validated email
	 */
	public String validateEmail(String email) {
		Pattern p = Pattern.compile(VALID_EMAIL_REGEX);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			return INVALID_EMAIL;
		} else {
			return email;
		}

	}
}
