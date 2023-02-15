/**
 * Project: A00123456Lab4
 * File: Validator.java
 * Date: Oct 11, 2015
 * Time: 5:03:59 PM
 */

package a00123456.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import a00123456.ApplicationException;

/**
 * @author iNoah, A00123456
 *
 */
public class Validator {
	public static final String VALID_EMAIL_REGEX = "[a-zA-z]+@[0-9a-zA-Z_]+\\.[a-zA-Z]{2,6}";
	public static final String INVALID_EMAIL = "N/A";

	/**
	 * Validate email.
	 *
	 * @param email
	 *            the email
	 * 
	 * @return the validated email
	 * @throws ApplicationException
	 */
	public String validateEmail(String email) throws ApplicationException {
		Pattern p = Pattern.compile(VALID_EMAIL_REGEX);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new ApplicationException("'" + email + "'" + " is an invalid email address");
			// return INVALID_EMAIL;
		} else {
			return email;
		}

	}
}
