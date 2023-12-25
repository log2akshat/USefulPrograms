package switchCase

import "fmt"

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
