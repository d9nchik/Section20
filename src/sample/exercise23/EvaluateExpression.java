package sample.exercise23;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }
    }

    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, −, /, and *
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: Scan tokens
        for (String token : tokens) {
            if (token.length() == 0) // Blank space
                continue; // Back to the while loop to extract the next token
            else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '-' || token.charAt(0) == '+') {
                // Process all *, / in the top of the operator stack
                while (!operatorStack.isEmpty()) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else { // An operand scanned
                // Push an operand to the stack
                operandStack.push(Integer.valueOf(token));
            }
        }

        // Phase 2: Process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop();
    }

    /**
     * Process one operator: Take an operator from operatorStack and
     * apply it on the operands in the operandStack
     */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    public static String insertBlanks(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/')
                result.append(" ").append(s.charAt(i)).append(" ");
            else
                result.append(s.charAt(i));
        }

        return result.toString();
    }
}
