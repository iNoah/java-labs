/**
 * Project: A00123456Lab5
 * File: Player.java
 * Date: Jan 14, 2014
 * Time: 9:25:43 PM
 */

package a00123456.data;

import java.time.LocalDateTime;

/**
 * @author iNoah, A00123456
 *
 */
public class Player {

	public static final int ATTRIBUTE_COUNT = 6;
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String gamerTag;
	private LocalDateTime birthDate;

	/**
	 * Default Constructor
	 */
	public Player() {
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param gamerTag
	 */
	public Player(int id, String firstName, String lastName, String emailAddress, String gamerTag) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.gamerTag = gamerTag;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the gamerTag
	 */
	public String getGamerTag() {
		return gamerTag;
	}

	/**
	 * @param gamerTag
	 *            the gamerTag to set
	 */
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Set the birthdate
	 * 
	 * @param year
	 *            the year, includes the century, ex. 1967
	 * @param month
	 *            the month - must be 0-based
	 * @param day
	 *            the day of the month - 1-based
	 */
	public void setBirthDate(int year, int month, int day) {
		birthDate = LocalDateTime.of(year, month, day, 0, 0);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", gamerTag=" + gamerTag + ", birthDate=" + birthDate
				+ "]";
	}

}
