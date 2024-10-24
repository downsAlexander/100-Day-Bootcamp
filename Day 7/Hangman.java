import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"aardvark", "camel", "hedgehog"};
    private static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String chosenWord = selectRandomWord();
        StringBuilder display = new StringBuilder("_".repeat(chosenWord.length()));
        HashSet<Character> correctLetters = new HashSet<>();
        HashSet<Character> lettersGuessed = new HashSet<>();
        int lives = MAX_LIVES;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Current word: " + display);
            System.out.println("Lives left: " + lives);
            char guess = getUserGuess(userInput);

            if (lettersGuessed.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue; // Skip the rest of the loop
            }

            lettersGuessed.add(guess);
            if (chosenWord.indexOf(guess) >= 0) {
                correctLetters.add(guess);
                updateDisplay(chosenWord, display, correctLetters);
            } else {
                lives--;
            }

            if (display.toString().equals(chosenWord)) {
                System.out.println("You win! The word was: " + chosenWord);
                gameOver = true;
            } else if (lives <= 0) {
                System.out.println("You lose! The word was: " + chosenWord);
                gameOver = true;
            }
        }
        userInput.close();
    }

    private static String selectRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    private static char getUserGuess(Scanner userInput) {
        char guess;
        while (true) {
            System.out.print("Guess a letter: ");
            String input = userInput.nextLine();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                guess = Character.toLowerCase(input.charAt(0)); // Normalize to lowercase
                break;
            } else {
                System.out.println("Please enter a valid single letter.");
            }
        }
        return guess;
    }

    private static void updateDisplay(String chosenWord, StringBuilder display, HashSet<Character> correctLetters) {
        StringBuilder newDisplay = new StringBuilder();
        for (char letter : chosenWord.toCharArray()) {
            if (correctLetters.contains(letter)) {
                newDisplay.append(letter);
            } else {
                newDisplay.append('_');
            }
        }
        display.setLength(0); // Clear the current display
        display.append(newDisplay); // Update display with the new state
    }
}
