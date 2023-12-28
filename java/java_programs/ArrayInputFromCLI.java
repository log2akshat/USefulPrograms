import java.util.Scanner;

public class ArrayInputFromCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        // Create an array of the given size
        int[] arr = new int[size];
        
        // Enter values for the array
        System.out.println("Enter " + size + " integer values for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for element " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // Print the entered array
        System.out.println("Entered array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

