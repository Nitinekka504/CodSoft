import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static String getFeedback(int guess, int number) {
        if (guess < number) {
            return (guess + 10 < number) ? "too low" : "a little low";
        } else if (guess > number) {
            return (guess - 10 > number) ? "too high" : "a little high";
        } else {
            return "correct";
        }
    }

    public static int playRound(Scanner scanner) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;
 
        System.out.println("\nGuess the number (between 1 and 100):");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": ");
            int guess = scanner.nextInt();
            attempts++;

            String feedback = getFeedback(guess, number);

            if (feedback.equals("correct")) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return attempts;
            } else {
                System.out.println("Your guess is " + feedback + ".");
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
        return maxAttempts;
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        int totalAttempts = 0;
        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")) {
            rounds++;
            int attempts = playRound(scanner);
            totalAttempts += attempts;

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }

        System.out.println("\nGame Over! You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.printf("Your average attempts per round were: %.2f%n", (double) totalAttempts / rounds);
        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}