package com.ticket.booking.cache;

import java.util.Map;

import com.ticket.booking.bean.Passenger;

/**
 * @author rupal
 *
 */
public interface Cache {
	
	public void addEntry(String tikcetId, Passenger passenger);
	
	public Passenger getEntry(String tikcetId);
	
	public Map<String, Passenger> getAllEntry();

	public void removeEntry(String tikcetId);

}
