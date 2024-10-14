import java.util.Scanner;

public class TreasureIsland {
    

    public TreasureIsland() {
        // constructor
    }

    public static void main(String[] arg){
        Scanner userInput = new Scanner(System.in);

        System.out.println("=============================================================");
        System.out.println("Welcome to treasure island, a choose your own adventure game!");
        System.out.println("=============================================================");
        System.out.println("Your mission is to find the treasure.");

        System.out.println("You start at a fork in the road, left or right?");
        String fork = userInput.nextLine();

        if (fork.equalsIgnoreCase("left")) {
            System.out.println("Spike pit. Of course pirates boobytrap their treasure.");
            System.out.println("Game over.");
            userInput.close();
        } else {
            System.out.println("You keep moving forward and reach a river spanned by an old bridge. 50/50 chance it collapses from your estimation.");
            System.out.println("Do you risk the bridge or try to swim across? (bridge or swim)");
            String bridge = userInput.nextLine();
            if (bridge.equalsIgnoreCase("swim")) {
                System.out.println("There were alligators in the water. There's always gators in the water."); 
                System.out.println("Game over.");
                userInput.close();
            } else{
                System.out.println("You decide to go for the bridge. Who knows what lurks below the surface of the water.");
                System.out.println("The bridge holds up. You make it across.");
                System.out.println("After a while, you come up to an odd sight.");
                System.out.println("There are three doors embedded into the face of a rock wall. The doors are numbered: 4, 7, and 42.");
                System.out.println("Which do you choose?");
                int door = userInput.nextInt();
                if (door == 42) {
                    System.out.println("You found the treasure! You win!");
                    userInput.close();
                } else {
                    System.out.println("More boobytraps. Use your imagination.");
                    System.out.println("Game over.");
                    userInput.close();
                }
            }
        }


    }
}