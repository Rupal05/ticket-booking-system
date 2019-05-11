package com.ticket.booking.processor.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ticket.booking.bean.BookingResponse;
import com.ticket.booking.bean.Passenger;
import com.ticket.booking.cache.Cache;
import com.ticket.booking.cache.TicketBookingCache;
import com.ticket.booking.constants.TicketBookingConstants;
import com.ticket.booking.processor.IBookingProcessor;
import com.ticket.booking.util.TicketBookingProcessorUtil;
import com.ticket.booking.validator.TicketBookingValidator;

/**
 * @author rupal
 *
 */
@Service("iBookingProcessor")
public class TicketBookingProcessor implements IBookingProcessor {

	private Cache cache = null;
	
	boolean ifBookingExists = false;

	public TicketBookingProcessor() {
		cache = TicketBookingCache.getInstance();
	}

	/**
	 * This is used to book the ticket for a new passenger
	 * 
	 * @param passenger
	 * @return BookingResponse
	 */
	public BookingResponse book(Passenger passenger) {

		if (!TicketBookingValidator.validateBookingRequest(passenger)) {
			return TicketBookingProcessorUtil.buildResponse(null, passenger, TicketBookingConstants.BOOKING_FAILURE);
		}

		String ticketId = String.valueOf(System.currentTimeMillis());
		cache.addEntry(ticketId, passenger);

		return TicketBookingProcessorUtil.buildResponse(ticketId, passenger, TicketBookingConstants.BOOKING_SUCCESS);
	}
	
	/**
	 * This is used to check if booking already exists for a passenger
	 * 
	 * @param dateOfJourney
	 * @param passportNumber
	 * @return ifBookingExists
	 */
	public boolean ifBookingExists(String dateOfJourney, String passportNumber)  {
		
		Map<String, Passenger> bookedRecords = cache.getAllEntry();
		
		bookedRecords.values().forEach((passenger) -> {
			if((dateOfJourney.compareTo(passenger.getDateOfJourney()) == 0) && 
					passportNumber.equalsIgnoreCase(passenger.getPassportNumber()))
					ifBookingExists = true;
			
		});
		return ifBookingExists;
	}

	/**
	 * This is used to fetch the passenger details based on ticketiD
	 * 
	 * @param ticketId
	 * @return Passenger
	 */
	public Passenger search(String ticketId)  {

		return cache.getEntry(ticketId);
	}

	/**
	 * This is used to cancel the ticket for a new passenger
	 * 
	 * @param ticketId
	 * @return String
	 */
	public String cancelTicketForPassenger(String ticketId) {

		if (cache.getEntry(ticketId) != null) {
			cache.removeEntry(ticketId);
			return TicketBookingConstants.BOOKING_CANCELLATION_SUCCESS + ticketId;
		}
		return TicketBookingConstants.BOOKING_CANCELLATION_FAILURE;
	}

}
