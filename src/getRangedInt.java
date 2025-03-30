import java.util.Scanner;

public class getRangedInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an integer within the range 1 to 10
        int userValue = getRangedInt(scanner, "Enter a number", 1, 10);

        // Output the valid input
        System.out.println("You entered: " + userValue);
    }

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int userInput;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: "); // Display the prompt with range

            // Ensure the input is a valid integer
            while (!console.hasNextInt()) {
                console.next(); // Clear invalid input
                System.out.print("Invalid input. " + prompt + " [" + low + " - " + high + "]: ");
            }

            userInput = console.nextInt(); // Read the input
            console.nextLine(); // Clear the newline character

            // Check if the input is within the specified range
            if (userInput < low || userInput > high) {
                System.out.println("Input out of range. Please try again.");
            }

        } while (userInput < low || userInput > high); // Repeat until valid input is provided

        return userInput;
    }
}






