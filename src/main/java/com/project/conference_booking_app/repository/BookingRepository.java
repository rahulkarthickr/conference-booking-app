package com.project.conference_booking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.conference_booking_app.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByFirstName(String firstName);

    List<Booking> findByLastName(String lastName);

    List<Booking> findByEmail(String email);

    long countByFirstName(String firstName);

    List<Booking> findByTickets(int tickets);

    List<Booking> findByFirstNameAndLastName(String firstName, String lastName);
}
