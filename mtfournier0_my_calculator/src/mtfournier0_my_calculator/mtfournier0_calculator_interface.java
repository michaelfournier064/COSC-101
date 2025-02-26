package mtfournier0_my_calculator;

import java.util.Scanner;
import static mtfournier0_my_calculator.mtfournier0_calculator_guts.calculator_single_instance;

public class mtfournier0_calculator_interface {
    // Create a single Scanner instance to be used throughout the program.
    public static Scanner scanner = new Scanner(System.in);
    
    // Helper class to store user input data
    public static class OperationData {
        public char operation;
        public double input1;
        public double input2;
        public String loopchoice;
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
    
    // Method to gather numeric inputs from the user and store them
    public static OperationData numberChoice(OperationData data) {
        System.out.println("What is your first number?");
        data.input1 = scanner.nextDouble();
        
        System.out.println("What is your second number?");
        data.input2 = scanner.nextDouble();
        
        return data;
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
                    break;
                } else if (loopchoice.equalsIgnoreCase("No")) {
                    System.out.println("Exiting calculator.");
                    scanner.close();
                    return;
                } else {
                    System.out.println("Invalid input. Please answer with Yes or No.");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Michael Fournier COSC101");
        System.out.println("This is my calculator project");
        
        calculator_looping();
    }
}
