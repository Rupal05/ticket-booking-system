/**
 * 
 */
package com.ticket.booking.util;

import com.ticket.booking.bean.BookingResponse;
import com.ticket.booking.bean.Passenger;

/**
 * @author Rupal
 *
 */
public class TicketBookingProcessorUtil {

	public static BookingResponse buildResponse(String ticketId, Passenger passenger, String status) {

		BookingResponse response = new BookingResponse();
		response.setTicketId(ticketId);
		response.setPassportNumber(passenger.getPassportNumber());
		response.setBookingStatus(status);
		return response;
	}

}
