package main

import (
	userInput "booking-app/helper"
	"fmt"
)

/** Global level variables
* Capatalize the first leeter of the variables
* so that it can be used in other packages globally who imports them
 */
// var RemainingTickets uint = 50 // untyped int, can't be negative

/**
* Package level variables
* When we assign the value to a variable in the same line
* Go can infer the datatype based on the value
 */
const totalConferenceTickets = 50

var conferenceName = "Go Conference"
var remainingTickets uint = 50 // untyped int, can't be negative
// var bookings = []string{} // Uncomment if you want to use Slice instead of Map

/**
* List of Maps defined as bookings
* It is an alternative way to create slice
* We need to define the initial size of the slice and it can grow dynamically
 */
// var bookings = make([]map[string]string, 0) // Uncomment if you want to use maps instead of struct

/**
* List of Struct defined as bookings
* It is an alternative way to create map
* `type` keyword creates a new type
* Can be compared to Classes in Java
 */
type UserData struct {
	firstName       string
	lastName        string
	email           string
	numberOfTickets uint
}

var bookings = make([]UserData, 0) // List of Struct

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
		firstName, lastName, email, userTickets := userInput.GetUserInput()

		// Validate the user Input
		isValidName, isValidEmail, isValidTicketCount := userInput.ValidateUserInput(firstName, lastName, email, userTickets, remainingTickets)

		if isValidName && isValidEmail && isValidTicketCount {
			// Book Tickets
			bookTickets(firstName, lastName, userTickets, email)

			// Creating list of only first names
			fmt.Printf("\nThe first name of users who have booked the tickets: %v\n", getFirstNames())

			// End the program if all tickets are booked
			if remainingTickets == 0 {
				fmt.Printf("All the tickets of %v are booked..\n", conferenceName)
				break
			}
		} else {
			// User Input Validations
			if !isValidName {
				fmt.Println("You have entered first name or last name too short")
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

func bookTickets(firstName string, lastName string, userTickets uint, email string) {

	remainingTickets = remainingTickets - uint(userTickets)

	/**
	* Maps
	* ----
	* Built-in data structure that provides an unordered collection of key-value pairs.
	* It is similar to dictionaries or associative arrays in other programming languages.
	* Maps are used to store and retrieve values based on a unique key.
	*
	* Maps must be initialized before use. You can use the `make`` function to create a new map.
	* GoLang maps are dynamic in size, and their keys must be of a type that supports equality
	* comparisons (e.g., integers, strings, structs with comparable fields).
	* Maps provide an efficient way to perform lookups and updates based on keys.
	*
	* Also, we cannot mix datatypes in Map
	 */

	// Create a map for a user
	/**
	* Uncomment if you want to use Map functiality and comment Struct functionality
	var userData = make(map[string]string) // make initializes the map
	userData["firstName"] = firstName
	userData["lastName"] = lastName
	userData["email"] = email
	// Convert tickets to string as GoLang map cannot have mix datatypes
	userData["ticketsBooked"] = strconv.FormatUint(uint64(userTickets), 10)
	*/

	/**
	* Struct
	* ------
	* struct is a composite data type that groups together variables (fields or members)
	* under a single name.
	* Each field in a struct can have a different data type unlike map which can have only
	* one datatype, and structs are commonly used to represent real-world entities with
	* multiple attributes.
	*
	* Fields: Fields in a struct can have different data types, including other structs.
	* Initialization: We can initialize a struct using the field names and corresponding values.
	* Anonymous Structs: We can create anonymous structs on the fly without defining a named type.
	* Zero Values: If a field is not explicitly initialized, it takes its zero value
	*              (e.g., 0 for numeric types, "" for strings).
	* Embedded Structs: We can embed one struct into another to create a composition of structures.
	*
	 */
	var userData = UserData{
		firstName:       firstName,
		lastName:        lastName,
		email:           email,
		numberOfTickets: userTickets,
	}

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
	* bookings[0] = firstName + " " + lastName
	* bookings[51] = firstName + " " + lastName // index 51 out of bounds
	 */

	bookings = append(bookings, userData)
	//fmt.Printf("The whole Array/Slice: %v\n", bookings)
	//fmt.Printf("The first value of Array/Slice: %v\n", bookings[0])
	//fmt.Printf("The Array/Slice Type: %T\n", bookings)
	//fmt.Printf("The Array/Slice length: %v\n", len(bookings))

	fmt.Printf("Thank you %v %v for booking %v tickets\nYou will recieve confirmation message on %v\n", firstName, lastName, userTickets, email)
	fmt.Println("\n-------------------- GO Conference Ticket Booking System --------------------")
	fmt.Printf("List of all bookings:%v\n", bookings)
	// Iterating over the Map
	/** Uncomment if you wish to use Map Functionality
	for key, value := range bookings {
		fmt.Printf("User %v:\n", key)
		for userDetailsKey, userDetailsValue := range value {
			fmt.Println("  * ", userDetailsKey, ":", userDetailsValue)
		}
	}
	*/

	// Iterate over the slice and print each user from struct
	for userId, user := range bookings {
		fmt.Printf("User %v:\n", userId)
		fmt.Printf("  * Name: %s %s\n", user.firstName, user.lastName)
		fmt.Printf("  * Email: %s\n", user.email)
		fmt.Printf("  * Tickets Booked: %d\n", user.numberOfTickets)
	}
	fmt.Println()
	fmt.Printf("Now, only %d tickets are left for the %v\n", remainingTickets, conferenceName)
	fmt.Println("-------------------- GO Conference Ticket Booking System --------------------")

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
		// var name = strings.Fields(element)
		// firstNames = append(firstNames, name[0]) // Uncomment if using Slice
		// firstNames = append(firstNames, element["firstName"]) // Uncomment if using Maps
		firstNames = append(firstNames, element.firstName)
	}
	return firstNames
}
