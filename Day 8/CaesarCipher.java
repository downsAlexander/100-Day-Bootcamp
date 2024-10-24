import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class CaesarCipher {
    private static final ArrayList<Character> symbols = new ArrayList<>(Arrays.asList(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
        '0', '9', '8', '7', '6', '5', '4', '3', '2', '1', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', 
        '{', '}', ';', ':', ',', '.', '/', '?'
    ));

    private static StringBuilder caesar(String direction, String text, int shift) {
        StringBuilder newText = new StringBuilder();
        ArrayList<Character> symbolList = new ArrayList<>(symbols); // Convert HashSet to ArrayList
        if (direction.equalsIgnoreCase("decode")) {
            shift *= -1;
        }
        for (char letter : text.toCharArray()) {
            if (!symbols.contains(letter)) {
                newText.append(letter);
            } else {
                newText.append(symbolList.get((symbolList.indexOf(letter) + shift) % symbolList.size())); // Use ArrayList for indexing
            }
        }
        return newText; // Ensure the method always returns newText
    }

    public static void main(String[] args) {
        // ASCII Art Title
        // System.out.println(",adPPYba,   ,adPPYYba,   ,adPPYba, ,adPPYba, ,adPPYYba,  8b,dPPYba,  \n" +
        //                    "a8\"     \"\" \"\"  `Y8 a8P_____88 I8[    \"\" \"\"  `Y8   88P' \"Y8  \n" +
        //                    "8b         ,adPPPPP88   8PP\"\"\"\"`\"Y8ba,  ,adPPPPP 88   88          \n" +
        //                    "\"8a,   ,aa 88,    , 88\"8b,   ,aa aa    ]8I 88,    , 88   88          \n" +
        //                    " `\"Ybbd8'` \"8bbdP\"Y8 `\"Ybbd8'` \"YbbdP'` \"8bbdP\"Y8   88   \n" +
        //                    "            88             88                                 \n" +
        //                    "           \"\"              88                                 \n" +
        //                    "                           88                                 \n" +
        //                    " ,adPPYba,  88 8b,dPPYba,  88,dPPYba,    ,adPPYba,   8b,dPPYba,  \n" +
        //                    "a8\"     \" 88         88P' 8a      88  Pa8P_____88   88P' \"Y8  \n" +
        //                    "8b          88 88       d8 88       88  8PP\"\"\"\"\" 88          \n" +
        //                    "\"8a,   ,aa 88 88b,   ,a8\"88       88 \"8b,   ,aa    88          \n" +
        //                    " `\"Ybbd8'  88 88`YbbdP'`  88       88  `\"Ybbd8'     88          \n" +
        //                    "               88                                              \n" +
        //                    "               88           ");
        
        
        Scanner userInput = new Scanner(System.in);
        
        while (true) {
            System.out.println("Encode or decode?");
            String direction = userInput.nextLine();
            while(!direction.equals("decode") && !direction.equals("encode")) {
                System.out.println("Encode or decode?");
                direction = userInput.nextLine();
            }

            System.out.println("Enter your message:");
            String text = userInput.nextLine();

            System.out.println("Enter the shift amount:");
            int shift;
            while (true) {
                String input = userInput.nextLine(); // Read input as a String
                try {
                    shift = Integer.valueOf(input); // Try to convert the input to an Integer
                    break; // If successful, exit the loop
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer:");
                }
            }

            System.out.println("New Message: " + caesar(direction, text, shift));

            System.out.println("Type 'yes' if you want to use the tool again. Otherwise type 'no'.");
            String restart = userInput.nextLine();
            if (restart.equals("no")) {
                userInput.close();
                break;
            }


        }
    }



}
