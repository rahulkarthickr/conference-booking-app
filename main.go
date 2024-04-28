package main

import (
	"fmt"
	"strings"
)

func main() {
	conferenceName := "conference"
	const conferenceTickets = 50
	remainingTickets := conferenceTickets
	var bookings []string

	fmt.Printf("Welcome to %v booking application\n", conferenceName)
	fmt.Printf("We have a total of %v tickets and %v are still available\n", conferenceTickets, remainingTickets)
	fmt.Println("Get your tickets here to attend")

	for {
		var firstName, lastName, email string
		var userTickets int

		fmt.Println("Enter your first name:")
		fmt.Scan(&firstName)
		fmt.Println("Enter your last name:")
		fmt.Scan(&lastName)
		fmt.Println("Enter your email address:")
		fmt.Scan(&email)
		fmt.Println("Enter the number of tickets:")
		fmt.Scan(&userTickets)

		if userTickets > remainingTickets {
			fmt.Printf("Sorry, we only have %v tickets remaining.\n", remainingTickets)
			continue
		}

		fmt.Printf("User %v booked %v tickets.\n", firstName, userTickets)
		remainingTickets -= userTickets
		bookings = append(bookings, firstName+" "+lastName)

		fmt.Printf("Thank you %v %v for booking %v tickets. You will receive a confirmation email at %v\n", firstName, lastName, userTickets, email)
		fmt.Printf("%v tickets remaining for the %v\n", remainingTickets, conferenceName)

		var firstNames []string
		for _, booking := range bookings {
			names := strings.Fields(booking)
			firstNames = append(firstNames, names[0])
		}
		fmt.Printf("Names of the booked attendees: %v\n", firstNames)

		if remainingTickets == 0 {
			fmt.Println("Our conference is fully booked. Come back next year!")
			break
		}
	}
}
