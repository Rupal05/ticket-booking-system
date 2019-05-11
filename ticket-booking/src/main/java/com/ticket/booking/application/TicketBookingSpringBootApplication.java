package com.ticket.booking.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author rupal
 *
 */
@SpringBootApplication(scanBasePackages = {"com.ticket.booking"})
public class TicketBookingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingSpringBootApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
