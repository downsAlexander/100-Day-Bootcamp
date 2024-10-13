// Band Name Generator
import java.util.Scanner;



public class BandNameGenerator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Welcome to the Band Name Generator!");
        System.out.println("===================================");
        
        System.out.println("What is the name of the city your grew up in?");
        String city = userInput.nextLine();
        // userInput.close();

        System.out.println("What was/is the name of your first pet?");
        String pet = userInput.nextLine();
        userInput.close();
        
        System.out.println("Your band name could be: " + city + " " + pet + "!");

    }
}