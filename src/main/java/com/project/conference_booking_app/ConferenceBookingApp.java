package com.project.conference_booking_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.conference_booking_app.service.BookingService;

@SpringBootApplication
public class ConferenceBookingApp implements CommandLineRunner {

	@Autowired
	private BookingService bookingService;

	public static void main(String[] args) {
		SpringApplication.run(ConferenceBookingApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookingService.startBooking();
	}
}
