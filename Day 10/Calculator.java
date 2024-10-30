import java.util.Scanner;

public class Calculator {
    
    public static int getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    public static String getOperation(Scanner scanner) {
        while (true) {
            System.out.println("Pick an operation:\n    +\n    -\n    *\n    /");
            String ops = scanner.nextLine().trim();
            if (ops.equals("+") || ops.equals("-") || ops.equals("*") || ops.equals("/")) {
                return ops;
            } else {
                System.out.println("Invalid operation. Please choose one of the following: +, -, *, /");
            }
        }
    }

    public static Integer calcResult(int n1, int n2, String ops) {
        switch (ops) {
            case "+":
                return add(n1, n2);
            case "-":
                return subtract(n1, n2);
            case "*":
                return multiply(n1, n2);
            case "/":
                if (n2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return null;
                }
                return divide(n1, n2);
            default:
                return null; // This should never happen due to prior checks
        }
    }

    public static int add(int n1, int n2) {
        return n1 + n2;
    }

    public static int subtract(int n1, int n2) {
        return n1 - n2;
    }

    public static int multiply(int n1, int n2) {
        return n1 * n2;
    }

    public static int divide(int n1, int n2) {
        return n1 / n2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = getNumber(scanner, "What's the first number? ");
        while (true) {
            int n2 = getNumber(scanner, "What's the second number? ");
            String ops = getOperation(scanner);

            Integer result = calcResult(n1, n2, ops);
            if (result != null) {
                System.out.println(n1 + " " + ops + " " + n2 + " = " + result);
            } else {
                continue;
            }

            System.out.print("Type 'y' to continue calculating with " + result +                                                                                                              ", or type 'n' to exit: ");
            String cont = scanner.next().toLowerCase().trim();
            scanner.nextLine();
            if (!cont.equals("y")) {
                break;
            }
            n1 = result;
        }
        scanner.close();
    }
}
