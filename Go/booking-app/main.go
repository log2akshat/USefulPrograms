package main

import (
	"fmt"
	"strings"
)

/**
* Package level variables
* When we assign the value to a variable in the same line
* Go can infer the datatype based on the value
 */
const totalConferenceTickets = 50

var conferenceName = "Go Conference"
var remainingTickets uint = 50 // untyped int, can't be negative
var bookings = []string{}

func main() {
	/**
	* Syntatic Sugar of Go
	* Can't be used at package level variables
	* Create a variable and assign it, can't use it with constants
	 */
	sponsorName := "Google"

	greetUsers(sponsorName)

	// Infinite for loop
	for {
		// Get user input from getUserInput() function
		// Declaring and assigning the values into variables what we got from getUserInput() function
		firstName, lastName, email, userTickets := getUserInput()

		// Validate the user Input
		isValidName, isValidEmail, isValidTicketCount := validateUserInput(firstName, lastName, email, userTickets)

		if isValidName && isValidEmail && isValidTicketCount {
			// Book Tickets
			bookTickets(firstName, lastName, userTickets, email)

			// Creating list of only first names
			fmt.Printf("\nThe first name who have booked the tickets: %v\n", getFirstNames())

			// End the program if all tickets are booked
			if remainingTickets == 0 {
				fmt.Printf("All the tickets of %v are booked..\n", conferenceName)
				break
			}
		} else {
			// User Input Validations
			if !isValidName {
				fmt.Println("You have entered wrong first name or last name")
			}
			if !isValidEmail {
				fmt.Println("You have eneterd wrong e-mail ID")
			}
			if !isValidTicketCount {
				fmt.Printf("We have only %d tickets remaining, so you can't book %v tickets\n", remainingTickets, userTickets)
				//continue // use on reversing the if...else condition
			}
		}
	}
}

func greetUsers(sponsorName string) {
	fmt.Println("Hello, Welcome to", conferenceName, "Booking application, sposored by", sponsorName)
	// %v is the default placeholder
	fmt.Printf("We have total of %d tickets and %v tickets are available\n", totalConferenceTickets, remainingTickets)

	// %T gives the type of the variables and constants
	fmt.Printf("conferenceName is %T, totalConferenceTickets is %T and remainingTickets is %T\n", conferenceName, totalConferenceTickets, remainingTickets)

}

func getUserInput() (string, string, string, uint) {
	/**
	* Local Variables
	* ---------------
	* Defined inside a function or a block, can be accessed only inside that function or block
	* When we do not assign the value imediately Go do not know the value we are going to store
	* So it ask to define the type explictly
	 */
	var firstName string
	var lastName string
	var email string
	var userTickets uint

	/**
	* User Input from CLI
	* -------------------
	* Asks user for their name, from CLI and assign it to variable userName
	*
	* Pointers
	* --------
	* & => called pointer, which is a special variable in Go that points to memory
	* address of another variable. So, a pointer needs to be prefixed before userName
	* otherwise it will simply exist without taking input from CLI.
	* Example:
	* fmt.Println(&remainingTickets) => Gives the Memory Address
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

	// A Go function can return multiple values
	return firstName, lastName, email, userTickets
}

func validateUserInput(firstName string, lastName string, email string, userTickets uint) (bool, bool, bool) {
	isValidName := len(firstName) > 2 && len(lastName) > 2
	isValidEmail := strings.Contains(email, "@")
	isValidTicketCount := userTickets <= remainingTickets

	return isValidName, isValidEmail, isValidTicketCount
}

func bookTickets(firstName string, lastName string, userTickets uint, email string) {
	/**
	* Arrays and Slices
	* -----------------
	* Arrays is like list of element which is of fixed size in Go, can't have mixed data types in Go
	* var bookings [50]string // String Array of size 50
	*
	* Slices: Growable (Dynamic) Array
	* An abstraction over Array, add elements at the end of the slice, don't have index
	* var bookings []string
	* Declaring an empty Slice, Example => bookings := []string{}
	*
	 */
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
	fmt.Printf("Now, only %d tickets are left for the %v\n", remainingTickets, conferenceName)

}

func getFirstNames() []string {
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
	return firstNames
}

/** Sample code for switch statement
*
* switch - Allows variable to be tested for equality against a list of values
* default - Hand;es the case, if no match is found
*
 */
func sampleSwitchSnippet() {
	city := "Pune"
	switch city {
	case "Mumbai":
		// Execute code to book the tickets for Mumbai Go Conference
	case "Prizren", "Pristina":
		// Execute code to book the tickets for Mumbai Go Conference
	case "Taipei", "Hsinchu":
		// Execute code to book the tickets for Mumbai Go Conference
	case "Pune":
		// Execute code to book the tickets for Mumbai Go Conference
	default:
		fmt.Println("No valid city selected!")
	}
}
