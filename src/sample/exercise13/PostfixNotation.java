package sample.exercise13;

import java.util.Stack;

public class PostfixNotation {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].matches("[\\d\\s/*-+]+")) {
            System.out.println(
                    "Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }

        Stack<Integer> numbers = new Stack<>();
        String[] words = args[0].split("[ ]+");
        for (String word : words) {
            if (word.matches("[\\d]+"))
                numbers.push(Integer.parseInt(word));
            else switch (word.charAt(0)) {
                case '+':
                    numbers.push(numbers.pop() + numbers.peek());
                    break;
                case '-':
                    numbers.push(numbers.pop() - numbers.peek());
                    break;
                case '*':
                    numbers.push(numbers.pop() * numbers.peek());
                    break;
                case '/':
                    numbers.push(numbers.pop() / numbers.peek());
                    break;
            }
        }
        System.out.println(numbers.peek());
    }
}
