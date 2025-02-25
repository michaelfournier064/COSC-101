package mtfournier0_my_calculator;
import java.util.Scanner;

public class mtfournier0_calculator_guts {

    // Create a single Scanner instance to be used throughout the program.
    static Scanner scanner = new Scanner(System.in);

    // Helper class to store user input data
    static class OperationData {
        char operation;
        double input1;
        double input2;
        String loopchoice;
    }
    
    // Method to gather the operation symbol from the user and validate it
    public static OperationData operationChoice() {
        OperationData data = new OperationData();
        
        System.out.println("Enter an operation (+, -, *, /, %(mod))");
        data.operation = scanner.next().charAt(0);
        
        // Validate the operation symbol.
        if (data.operation != '+' && data.operation != '-' &&
            data.operation != '*' && data.operation != '/' && data.operation != '%') {
            System.out.println("Invalid operation. Please try again.");
            // Recursively call the method again to re-prompt for a valid operation.
            return operationChoice();
        }
        
        return data;
    }
    
    // Method to gather numeric inputs from the user and store them in the same OperationData instance
    public static OperationData numberChoice(OperationData data) {
        System.out.println("What is your first number?");
        data.input1 = scanner.nextDouble();
        
        System.out.println("What is your second number?");
        data.input2 = scanner.nextDouble();
        
        return data;
    }
    
    // Arithmetic functions
    public static void addition(double a, double b) {
        System.out.println("Result (Addition): " + (a + b));
    }
    
    public static void subtraction(double a, double b) {
        System.out.println("Result (Subtraction): " + (a - b));
    }
    
    public static void multiplication(double a, double b) {
        System.out.println("Result (Multiplication): " + (a * b));
    }
    
    public static void division(double a, double b) {
        if (b != 0) {
            System.out.println("Result (Division): " + (a / b));
        } else {
            System.out.println("Error: Division by zero.");
        }
    }
    
    public static void modulus(double a, double b) {
        System.out.println("Result (Modulus): " + (a % b));
    }
    
    // Method to perform a single calculation instance
    public static void calculator_single_instance() {
        // Gather the operation input from the user.
        OperationData data = operationChoice();
        // Gather the number inputs and store them in the same data object.
        data = numberChoice(data);
        
        // Use a switch-case to determine which arithmetic function to call.
        switch (data.operation) {
            case '+':
                addition(data.input1, data.input2);
                break;
            case '-':
                subtraction(data.input1, data.input2);
                break;
            case '*':
                multiplication(data.input1, data.input2);
                break;
            case '/':
                division(data.input1, data.input2);
                break;
            case '%':
                modulus(data.input1, data.input2);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }
    
    // Method to loop the calculator based on user choice.
    public static void calculator_looping() {
        while (true) {
            // Perform a single calculation.
            calculator_single_instance();
            
            // Loop until we get a valid input.
            while (true) {
                System.out.println("Would you like to calculate another value? (Yes or No)");
                String loopchoice = scanner.next();
                
                if (loopchoice.equalsIgnoreCase("Yes")) {
                    // Valid input: continue to the next calculation.
                    break;
                } else if (loopchoice.equalsIgnoreCase("No")) {
                    // Valid input: exit the looping method.
                    System.out.println("Exiting calculator.");
                    return;
                } else {
                    // Invalid input: notify and re-prompt.
                    System.out.println("Invalid input. Please answer with Yes or No.");
                }
            }
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Michael Fournier COSC101");
        System.out.println("This is my calculator project");
        
        // Start the looping calculator
        calculator_looping();
        
        // Close the scanner once all input has been processed.
        scanner.close();
    }
}
