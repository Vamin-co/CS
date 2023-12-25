/**
 * Author: Vandan Amin
 * Date: Oct 25, 2023
 * Lab 5: EvaluateExpressions.java
 */

import java.util.Stack;

public class EvaluateExpressions {

    // Converts an infix expression to a postfix expression
    public static String convertToPostFix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        String operators = "+-*/";

        for (char token : infixExpression.toCharArray()) {
            if (Character.isDigit(token)) {
                // If the token is a digit or a decimal point, add it to the postfix expression
                postfixExpression.append(token);
            } else if (operators.indexOf(token) != -1) {
                // If the token is an operator (+, -, *, /), handle it
                postfixExpression.append(' ');
                while (!operatorStack.isEmpty() && operatorPrecedence(token) <= operatorPrecedence(operatorStack.peek())) {
                    // Pop operators from the stack and add them to the postfix expression
                    postfixExpression.append(operatorStack.pop());
                    postfixExpression.append(' ');
                }
                // Push the current operator onto the stack
                operatorStack.push(token);
            }
        }

        // Pop any remaining operators from the stack and add them to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(' ');
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString().trim();
    }

    // Evaluates a postfix expression
    public static double evaluatePostFix(String postfixExpression) {
        Stack<Double> operandStack = new Stack<>();
        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (!token.isEmpty()) {
                if (isNumeric(token)) {
                    // If the token is numeric, push it onto the operand stack
                    operandStack.push(Double.parseDouble(token));
                } else {
                    // If the token is an operator, perform the operation on the top operands from the stack
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    switch (token) {
                        case "+":
                            operandStack.push(operand1 + operand2);
                            break;
                        case "-":
                            operandStack.push(operand1 - operand2);
                            break;
                        case "*":
                            operandStack.push(operand1 * operand2);
                            break;
                        case "/":
                            if (operand2 == 0) {
                                throw new ArithmeticException("Division by zero");
                            }
                            operandStack.push(operand1 / operand2);
                            break;
                    }
                }
            }
        }

        // The result is the last item left on the operand stack
        if (operandStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return operandStack.pop();
    }

    // Determines operator precedence (higher value means higher precedence)
    private static int operatorPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    // Checks if a string represents a numeric value
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}