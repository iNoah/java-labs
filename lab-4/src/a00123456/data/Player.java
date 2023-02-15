/**
 * Project: A00123456Lab4
 * File: Player.java
 * Date: Oct 11, 2015
 * Time: 4:54:20 PM
 */

package a00123456.data;

import java.util.GregorianCalendar;

/**
 * @author iNoah, A00123456
 *
 */
public class Player {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String gamertag;
	private GregorianCalendar birthDate;

	public Player(int id, String firstName, String lastName, String email, String gamertag, GregorianCalendar birthDate) {
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setGamertag(gamertag);
		setBirthDate(birthDate);
	}

	/**
	 * Sets the id.
	 *
	 * @param id2
	 *            the new id
	 */
	public final void setId(int id2) {
		this.id = id2;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the gamertag.
	 *
	 * @param gamertag
	 *            the new gamertag
	 */
	public final void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	}

	public final void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the gamertag.
	 *
	 * @return the gamertag
	 */
	public String getGamertag() {
		return gamertag;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

}
