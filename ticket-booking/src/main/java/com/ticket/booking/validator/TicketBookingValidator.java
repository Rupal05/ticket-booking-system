package com.ticket.booking.validator;

import com.ticket.booking.bean.Passenger;

/**
 * @author rupal
 *
 */
public class TicketBookingValidator {

	public static boolean validateBookingRequest(Passenger passenger) {

		if (isNullOrEmpty(passenger.getFirstName())) {
			return false;
		}
		if (isNullOrEmpty(passenger.getLastName())) {
			return false;
		}
		if (isNullOrEmpty(passenger.getPassportNumber())) {
			return false;
		}
		

		return true;
	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

}
