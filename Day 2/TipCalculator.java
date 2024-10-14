// Tip Calculator - Day 2

import java.util.Scanner;

// calculator class
public class TipCalculator {

    Scanner userInput = new Scanner(System.in);
    double bill;
    String serviceLevel;
    int groupSize;
    double tipPercentage;
    double tip;
    
    // constructor
    public TipCalculator() {

    }

    // greet the user and collect the information required to calculate the tip amount
    public void greetUser() {
        System.out.println("Welcome to the tip calculator!");
        System.out.println("==============================");

        System.out.println("What was the total bill?");
        bill = userInput.nextDouble();
        userInput.nextLine();
        // System.out.println(bill);

        System.out.println("How would you rate the service? (poor, standard, exceptional)");
        serviceLevel = userInput.nextLine();
        // System.out.println(serviceLevel);

        System.out.println("How many people are splitting the bill?");
        groupSize = userInput.nextInt();
        // System.out.println(groupSize);

        userInput.close();
    }

    // printing the tip amount for the user
    public String postTip() {
        return ("Your share of the tip is: " + tip);
    }

    // setting the tip percentage based on reported service level and then calculating and returning the tip amount as a double
    public double calcTip() {
        switch(serviceLevel) {
            case "poor":
                tipPercentage = .1;
                break;
            case "standard":
                tipPercentage = .2;
                break;
            case "exceptional":
                tipPercentage = .25;
                break;
            default:
                tipPercentage = .15;
                break;
            }
        tip = (bill * tipPercentage)/groupSize;
        return tip;
    }

    // main function
    public static void main(String[] args) {
        TipCalculator tip1 = new TipCalculator();
        tip1.greetUser();
        tip1.calcTip();
        System.out.println(tip1.postTip());
        // System.out.println(postTip(calcTip(bill, serviceLevel, groupSize)));
    }
}