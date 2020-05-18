package sample.exercise11;

import java.util.Scanner;
import java.util.Stack;

public class StackProperties {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 decimal: ");
        for (int i = 0; i < 10; i++) {
            int numberFromConsole = input.nextInt();
            if (integers.empty() || numberFromConsole != integers.peek())
                integers.push(numberFromConsole);
        }

        System.out.println("You entered: ");
        while (!integers.empty())
            System.out.print(integers.pop() + " ");
    }
}
