package main

import (
	"fmt"
	"strings"
)

func main() {

	// When we assign the value to a variable in the same line Go can infer the datatype based on the value
	var conferenceName = "Go Conference"
	const totalConferenceTickets = 50
	var remainingTickets uint = 50 // untyped int, can't be negative

	// Syntatic Sugar of Go
	// Create a variable and assign it, can't use it with constants
	sponsorName := "Google"

	fmt.Println("Hello, Welcome to", conferenceName, "Booking application, sposored by", sponsorName)
	// %v is the default placeholder
	fmt.Printf("We have total of %d tickets and %v tickets are available\n", totalConferenceTickets, remainingTickets)

	// %T gives the type of the variables and constants
	fmt.Printf("conferenceName is %T, totalConferenceTickets is %T and remainingTickets is %T\n", conferenceName, totalConferenceTickets, remainingTickets)

	// When we do not assign the value imediately Go do not know the value we are going to store
	// So it ask to define the type explictly
	var firstName string
	var lastName string
	var email string
	var userTickets uint

	// Arrays is like list of element which is of fixed size in Go, can't have mixed data types in Go
	//var bookings [50]string // String Array of size 50

	// Slices: Growable (Dynamic) Array (an abstraction over Array, add elements at the end of the slice, don't have index)
	// var bookings []string
	// Declaring an empty Slice
	bookings := []string{}

	// Infinite for loop
	for {
		/**
		* Asks user for their name, from CLI and assign it to variable userName
		* & (called pointer, which is a special variable in Go) that points to memory address of another variable
		* So, a pointer needs to be prefixed before userName otherwise it will simply exist without taking input from CLI
		* E.g:
		* fmt.Println(&remainingTickets) // Gives the Memory Address
		*
		* Now, scan() function can assign the user's value to the userName variable
		* Because it has pointer to its memory address
		 */
		fmt.Println()
		fmt.Println("Enter your First Name")
		fmt.Scan(&firstName)

		fmt.Println("Enter your Last Name")
		fmt.Scan(&lastName)

		fmt.Println("Enter your Email Id")
		fmt.Scan(&email)

		fmt.Println("Enter the number of tickets you want")
		fmt.Scan(&userTickets)

		remainingTickets = remainingTickets - uint(userTickets)
		// bookings[0] = firstName + " " + lastName
		// bookings[51] = firstName + " " + lastName // index 51 out of bounds
		bookings = append(bookings, firstName+" "+lastName)

		//fmt.Printf("The whole Array/Slice: %v\n", bookings)
		//fmt.Printf("The first value of Array/Slice: %v\n", bookings[0])
		//fmt.Printf("The Array/Slice Type: %T\n", bookings)
		//fmt.Printf("The Array/Slice length: %v\n", len(bookings))

		fmt.Println("--------------------------------------------")
		fmt.Printf("Thank you %v %v for booking %v tickets\nYou will recieve confirmation message on %v\n", firstName, lastName, userTickets, email)
		fmt.Printf("Now, only %d are left for the %v\n", remainingTickets, conferenceName)

		// Creating list of only first names
		firstNames := []string{}

		/**
		* for each loop
		* for index, element := range bookings { logic for defining for loop }
		* index 	- index of the elememts
		* element 	- element of the Array/Slice
		* range 	- allows us to iterate over elements for different data structures (not only Arrays/Slices)
		* 			  For Arrays/Slices, range provides the index and value for each element
		* Fields 	- This function comes from string package, which splits the string eith whitespace as separator
		*          	  Returns the slice with the split elements
		* _ 	 	- Blank Identifier used to ignore a variable we don't want to use.
					  Instead of using index we are using _
		*/
		for _, element := range bookings {
			var name = strings.Fields(element)
			firstNames = append(firstNames, name[0])
		}
		fmt.Printf("\nThe first name who have booked the tickets: %v\n", firstNames)

	}

}
