import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class RockPaperScissors {

    public RockPaperScissors() {
        // constructor
    }

// pieces = ["rock", "paper", "scissors"]


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random random = new Random();
        String[] pieces = {"rock", "paper", "scissors"};
        int randomIndex = random.nextInt(pieces.length);
        String computerChoice = pieces[randomIndex];

        System.out.println("Rock, Paper, Scissors Game");
        System.out.println("==========================");

        System.out.println("Rock, paper, scissors...shoot! (make your choice) ");
        String userChoice = userInput.nextLine();
        userInput.close();


        if (userChoice.equalsIgnoreCase(computerChoice)) { 
            System.out.println("You chose " + userChoice + ".");
            System.out.println("The computer chose " + computerChoice + ".");
            System.out.println("It is a tie!");
            } else if (userChoice.equalsIgnoreCase("rock")){ 
                if (computerChoice.equalsIgnoreCase("paper")){
                    System.out.println("You chose " + userChoice + ".");
                    System.out.println("The computer chose " + computerChoice + ".");
                    System.out.println("You lose!");
                } else {
                    System.out.println("You chose " + userChoice + ".");
                    System.out.println("The computer chose " + computerChoice + ".");
                    System.out.println("You win!");
                }
            } else if (userChoice.equalsIgnoreCase("paper")) {
                if (computerChoice.equalsIgnoreCase("scissors")){
                    System.out.println("You chose " + userChoice + ".");
                    System.out.println("The computer chose " + computerChoice + ".");
                    System.out.println("You lose!");
                } else {
                    System.out.println("You chose " + userChoice + ".");
                    System.out.println("The computer chose " + computerChoice + ".");
                    System.out.println("You win!");
                }
            } else if (userChoice.equalsIgnoreCase("scissors")) {
                if (computerChoice.equalsIgnoreCase("roc")){
                    System.out.println("You chose " + userChoice + ".");
                    System.out.println("The computer chose " + computerChoice + ".");
                    System.out.println("You lose!");
                } else {
                    System.out.println("You chose " + userChoice + ".");
                    System.out.println("The computer chose " + computerChoice + ".");
                    System.out.println("You win!");
                }
            }
        }
    }
