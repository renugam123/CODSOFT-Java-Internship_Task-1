import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");

        while (playAgain) {

            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore++;
                    isGuessed = true;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }

            if (!isGuessed) {
                System.out.println("You lost! The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again (yes/no): ");
            sc.nextLine();
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your total score: " + totalScore);
        sc.close();
    }
}