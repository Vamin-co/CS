/**
 * Author: Vandan Amin
 * Date: Oct 25, 2023
 * Lab 5: Driver.java
 */

import java.io.*;

public class Driver {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("expressions.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("postFixExpressions.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Convert the infix expression to postfix
                String postfixExpression = EvaluateExpressions.convertToPostFix(line);
                double result;
                try {
                    // Evaluate the postfix expression
                    result = EvaluateExpressions.evaluatePostFix(postfixExpression);
                    System.out.println(postfixExpression + " evaluates to: " + result);
                } catch (ArithmeticException e) {
                    result = Double.NaN; // Set result to NaN for undefined division
                    System.out.println(postfixExpression + " evaluates to: Undefined (division by zero)");
                }
                // Write the postfix expression to the output file
                writer.write(postfixExpression + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


