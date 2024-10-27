import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

public class SilentAuction {
    private Scanner userInput; // Declare as instance variables
    private HashMap<Integer, String> bidDictionary;

    // Constructor
    public SilentAuction() {
        userInput = new Scanner(System.in); // Initialize Scanner
        bidDictionary = new HashMap<>(); // Initialize HashMap
        
    }

    private String printWinner(HashMap<Integer, String> bids) {
        if (bids.isEmpty()) {
            return "No bids were placed.";
        }
        int maxKey = Integer.MIN_VALUE;
        String winner = "";
        for (Integer key : bids.keySet()) {
            if (key > maxKey) { // Change to greater than
                maxKey = key;
                winner = bids.get(key); // Store the winner's name
            }
        }
        return winner + " won the bid with a bid of: " + maxKey;
    }

    private void acceptBids(HashMap<Integer, String> bidBook, Scanner userInput) {
        String name = ""; // Declare name outside the loop
        while (true) {
            System.out.println("Enter your name or bidder ID:");
            name = userInput.nextLine(); // Assign value to name
            if (name.length() <= 0) {
                System.out.println("Please provide your name or bidder ID.");
            } else {
                break; // Correctly break out of the first loop
            }
        }

        while (true) {
            try {
                System.out.println("Enter your bid as a full dollar amount:");
                int bid = userInput.nextInt();
                if (bidBook.containsKey(bid)) {
                    System.out.println("Bid of " + bid + " already exists. Please enter a new bid.");
                    continue;
                }
                bidBook.put(bid, name); // Store the bid with the name
                userInput.nextLine(); 
                break; // Exit the loop after a valid bid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a proper dollar amount.");
                userInput.next(); // Clear the invalid input
            }
        }
    }

    private boolean askForMoreBidders() {
        while (true) {
            System.out.println("Are there any other bidders?");
            String endAuction = userInput.nextLine();
            if (endAuction.equalsIgnoreCase("yes")) {
                clearConsole();
                return true;
            } else if (endAuction.equalsIgnoreCase("no")) {
                clearConsole();
                return false;
            } else if (!endAuction.equalsIgnoreCase("yes") && !endAuction.equalsIgnoreCase("no")) {
                System.out.println("Invalid response. Please confirm if there are any addtional bidders.");
            }
        }
    }

    private void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SilentAuction auction = new SilentAuction(); // Instantiate the class
        System.out.println("Welcome to the silent Auction.");
        boolean bidding = true; // Initialize boolean

        while (bidding) { // Use the instance variable
            auction.acceptBids(auction.bidDictionary, auction.userInput); // Pass the Scanner instance
            bidding = auction.askForMoreBidders(); // Update bidding status
        }
        System.out.println(auction.printWinner(auction.bidDictionary));
        auction.userInput.close();
    }
}
