package com.ticket.booking.bean;

/**
 * @author rupal
 *
 */
public class BookingResponse {

	public String ticketId;
	public String passportNumber;
	public String bookingStatus;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "BookingResponse [ticketId=" + ticketId + ", passportNumber=" + passportNumber + ", bookingStatus="
				+ bookingStatus + "]";
	}

}
