package com.ticket.booking.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ticket.booking.bean.BookingResponse;
import com.ticket.booking.bean.Passenger;
import com.ticket.booking.constants.TicketBookingConstants;
import com.ticket.booking.exception.PassengerNotFoundException;
import com.ticket.booking.processor.IBookingProcessor;



/**
 * Swagger can be used for APIs documentation
 * 
 * @author rupal
 */
@RestController
public class TicketbookingController {

	@Autowired
	IBookingProcessor bookingProcessor;

	@Autowired
	RestTemplate restTemplate;

	public static final String REST_SERVICE_URI = "http://localhost:8083/ifExists/passenger/";

	/**
	 * bookingTicketForPassenger : booking the new ticket for a requested passenger
	 * 
	 * @param passenger
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/ifExists/passenger/{dateOfJourney}/{passportNumber}")
	@ResponseBody
	public boolean ifExists(@PathVariable("dateOfJourney") String dateOfJourney,
			@PathVariable("passportNumber") String passportNumber) {

		return bookingProcessor.ifBookingExists(dateOfJourney, passportNumber);
	}

	/**
	 * bookingTicketForPassenger : booking the new ticket for a requested passenger
	 * 
	 * @param passenger
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/booking/passenger")
	@ResponseBody
	public ResponseEntity<BookingResponse> bookTicketForPassenger(@Valid @RequestBody Passenger passenger) {

		boolean ifExists = restTemplate.getForObject(
				REST_SERVICE_URI + passenger.getDateOfJourney() + "/" + passenger.getPassportNumber(), Boolean.class);

		if (ifExists) {
			BookingResponse bookingResponse = new BookingResponse();
			bookingResponse.setBookingStatus(TicketBookingConstants.BOOKING_ALREADY_EXISTS);
			return new ResponseEntity<BookingResponse>(bookingResponse, HttpStatus.BAD_REQUEST);
		}

		BookingResponse bookingResponse = bookingProcessor.book(passenger);

		return new ResponseEntity<BookingResponse>(bookingResponse, HttpStatus.OK);

	}

	/**
	 * fetchPassengerDetailBasedOnTicketId
	 * 
	 * @param ticketId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fetch/passenger/{ticketId}")
	@ResponseBody
	public ResponseEntity<Passenger> fetchPassengerDetailBasedOnTicketId(@PathVariable("ticketId") String ticketId) {

		Passenger passenger = bookingProcessor.search(ticketId);
		if (passenger == null)
			throw new PassengerNotFoundException("Invalid ticket id:" + ticketId);

		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	/**
	 * cancelBookingForPassenger
	 * 
	 * @param ticketId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/cancel/passenger/{ticketId}")
	@ResponseBody
	public String cancelBookingForPassenger(@PathVariable("ticketId") String ticketId) {

		return bookingProcessor.cancelTicketForPassenger(ticketId);
	}

}
