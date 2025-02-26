package mtfournier0_my_calculator;

import static mtfournier0_my_calculator.mtfournier0_calculator_interface.operationChoice;
import static mtfournier0_my_calculator.mtfournier0_calculator_interface.numberChoice;
import mtfournier0_my_calculator.mtfournier0_calculator_interface.OperationData;

public class mtfournier0_calculator_guts {
    public static void addition(double input1, double input2) {
        System.out.println("Result (Addition): " + (input1 + input2));
    }
    
    public static void subtraction(double input1, double input2) {
        System.out.println("Result (Subtraction): " + (input1 - input2));
    }
    
    public static void multiplication(double input1, double input2) {
        System.out.println("Result (Multiplication): " + (input1 * input2));
    }
    
    public static void division(double input1, double input2) {
        if (input2 != 0) {
            System.out.println("Result (Division): " + (input1 / input2));
        } else {
            System.out.println("Error: Division by zero.");
        }
    }
    
    public static void modulus(double input1, double input2) {
        System.out.println("Result (Modulus): " + (input1 % input2));
    }
    
    public static void calculator_single_instance() {
        // Gather the operation input from the user.
        OperationData data = operationChoice();
        // Gather the number inputs and store them in the same data object.
        data = numberChoice(data);
        
        // Determine which arithmetic function to call.
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
}
