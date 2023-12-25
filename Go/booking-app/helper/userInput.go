package userInput

import (
	"fmt"
	"strings"
)

/**
* Go Packages
* -----------
/*
* Go Packages and Code Organization:
*   - The code is further organized into Go packages, providing a modular and scalable structure.
*   - Packages help compartmentalize functionality, making it easier to manage, test, and maintain code.
*   - The use of packages enhances code reusability and fosters a more structured development approach.
*
* Note: Since these functions are not defined at the same package level,
*      but in another package, we need to capitalize the first letter
*      of the function. This enables us to use them in the main package.
*/

func GetUserInput() (string, string, string, uint) {
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

func ValidateUserInput(firstName string, lastName string, email string, userTickets uint, remainingTickets uint) (bool, bool, bool) {
	isValidName := len(firstName) > 2 && len(lastName) > 2
	isValidEmail := strings.Contains(email, "@")
	isValidTicketCount := userTickets <= remainingTickets

	return isValidName, isValidEmail, isValidTicketCount
}
