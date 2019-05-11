package com.ticket.booking.processor;

import java.util.Date;

import com.ticket.booking.bean.BookingResponse;
import com.ticket.booking.bean.Passenger;

/**
 * @author rupal
 *
 */
public interface IBookingProcessor {

	public BookingResponse book(Passenger passenger);

	public Passenger search(String ticketId);

	public String cancelTicketForPassenger(String ticketId);
	
	public boolean ifBookingExists(String dateOfJourney, String passportNumber);
}
