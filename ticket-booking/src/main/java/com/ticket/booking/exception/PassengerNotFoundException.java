package com.ticket.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PassengerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
		public PassengerNotFoundException(String exception) {
			super(exception);
		}

}
