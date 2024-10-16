import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class PasswordGenerator {
    
    public PasswordGenerator() {
        //constructor
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random random = new Random();
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                          'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numbers = {'0', '9', '8', '7', '6', '5', '4', '3', '2', '1'};
        char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', ';', ':', ',', '.', '/', '?'};
        ArrayList<Character> pw_charList = new ArrayList<Character>();
        

        System.out.println("Welcome to the Password Generator!");

        System.out.println("How many letters would you like in your password?\n");
        int nr_letters = userInput.nextInt();
        userInput.nextLine();

        System.out.println("How many symbols would you like?\n");
        int nr_symbols = userInput.nextInt();
        userInput.nextLine();

        System.out.println("How many numbers would you like?\n");
        int nr_integers = userInput.nextInt();
        userInput.close();

        for (int i = 0; i < nr_letters; i++) {
            int randomIndex = random.nextInt(letters.length);
            pw_charList.add(letters[randomIndex]);
        }

        for (int i = 0; i < nr_symbols; i++) {
            int randomIndex = random.nextInt(symbols.length);
            pw_charList.add(symbols[randomIndex]);
        }

        for (int i = 0; i < nr_integers; i++) {
            int randomIndex = random.nextInt(numbers.length);
            pw_charList.add(numbers[randomIndex]);
        }
        
        //shuffle the arraylist
        Collections.shuffle(pw_charList);
        //instantiate new pwd string
        String pwd = new String();
        //loop through each character and concatenate them into one string
        for (char elem : pw_charList) {
            pwd = pwd + elem;
        }
        //print out new password
        System.out.println(pwd);

    }
}
