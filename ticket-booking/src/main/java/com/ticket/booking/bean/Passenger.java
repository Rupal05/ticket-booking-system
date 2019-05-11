package com.ticket.booking.bean;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

/**
 * @author rupal
 *
 */
public class Passenger {

	@NotEmpty(message = "first name must not be empty")
	private String firstName;
	
	@NotEmpty(message = "last name must not be empty")
	private String lastName;
	
	@NotEmpty(message = "Passport must not be empty")
	private String passportNumber;
	
	@NotEmpty(message = "Date of journey must not be empty")
	private String dateOfJourney;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", passportNumber=" + passportNumber
				+ ", dateOfJourney=" + dateOfJourney + "]";
	}

	
}
