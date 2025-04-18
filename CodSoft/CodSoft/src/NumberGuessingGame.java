import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int score = 0; // Initialize score for the current round
            int attempts = 0; // Initialize attempts for the current round
            int maxAttempts = 5; // Set the maximum number of attempts
            int lowerBound = 1; // Lower bound of the random number
            int upperBound = 100; // Upper bound of the random number
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Generate random number

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a random number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number within the specified range (" + lowerBound + " to " + upperBound + ").");
                    attempts--; // Do not count this attempt
                    continue;
                }

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    score = maxAttempts - attempts + 1; // Calculate score based on attempts
                    System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                    System.out.println("Your score for this round is: " + score);
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low!!!. Try again.");
                } else {
                    System.out.println("Your guess is too high!!!. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + randomNumber);
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}