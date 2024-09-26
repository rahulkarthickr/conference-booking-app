package com.project.conference_booking_app.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.conference_booking_app.model.Booking;
import com.project.conference_booking_app.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    private static final String CONFERENCE_NAME = "Conference";
    private static final int TOTAL_TICKETS = 50;
    private int remainingTickets = TOTAL_TICKETS;

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void printBookingsByEmail(String email) {
        List<Booking> bookings = getBookingsByEmail(email);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found for this email.");
        } else {
            bookings.forEach(booking -> System.out.printf("Booking: %s %s - %d tickets\n",
                    booking.getFirstName(), booking.getLastName(), booking.getTickets()));
        }
    }

    public void startBooking() {
        System.out.printf("Welcome to %s booking application\n", CONFERENCE_NAME);
        System.out.printf("We have a total of %d tickets and %d are still available\n", TOTAL_TICKETS,
                remainingTickets);
        System.out.println("Get your tickets here to attend");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your email address:");
        String email = scanner.nextLine();
        System.out.println("Enter the number of tickets:");
        int userTickets = scanner.nextInt();
        scanner.nextLine();

        if (userTickets > remainingTickets) {
            System.out.printf("Sorry, we only have %d tickets remaining.\n", remainingTickets);
        } else {
            Booking booking = new Booking();
            booking.setFirstName(firstName);
            booking.setLastName(lastName);
            booking.setEmail(email);
            booking.setTickets(userTickets);
            saveBooking(booking);
            remainingTickets -= userTickets;
            System.out.printf("Thank you %s %s for booking %d tickets. You will receive a confirmation email at %s\n",
                    firstName, lastName, userTickets, email);
            System.out.printf("%d tickets remaining for the %s\n", remainingTickets, CONFERENCE_NAME);

            if (remainingTickets == 0) {
                System.out.println("Our conference is fully booked. Come back next year!");
            }
        }

        scanner.close();
    }

    public long getBookingCountByFirstName(String firstName) {
        return bookingRepository.countByFirstName(firstName);
    }

    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByEmail(email);
    }
}
