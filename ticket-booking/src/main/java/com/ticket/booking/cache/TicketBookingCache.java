package com.ticket.booking.cache;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ticket.booking.bean.Passenger;

/**
 * @author rupal
 *
 */
public class TicketBookingCache implements Cache{

	private static TicketBookingCache ticketBookingCache = null;

	Map<String, Passenger> bookingRecords;

	public TicketBookingCache() {

		bookingRecords = new LinkedHashMap<>();
	}

	public static TicketBookingCache getInstance() {

		if (ticketBookingCache == null) {
			ticketBookingCache = new TicketBookingCache();
			return ticketBookingCache;
		} else {
			return ticketBookingCache;
		}
	}

	/**
	 * 
	 * @param tikcetId
	 * @param passenger
	 */
	public void addEntry(String tikcetId, Passenger passenger) {
		bookingRecords.put(tikcetId, passenger);
	}
	
	/**
	 * get single Entry based on key
	 * @param tikcetId
	 */
	public Passenger getEntry(String tikcetId) {
		return bookingRecords.get(tikcetId);
	}
	
	/**
	 * getAllEntry
	 * @return Map<String, Passenger>
	 */
	public Map<String, Passenger> getAllEntry() {
		return bookingRecords;
	}

	/**
	 * 
	 * @param tikcetId
	 */
	public void removeEntry(String tikcetId) {
		bookingRecords.remove(tikcetId);
	}

}
