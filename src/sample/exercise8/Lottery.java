package sample.exercise8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Lottery {
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> lotteryNumber = new ArrayList<>();
        int lottery = (int) (Math.random() * 1000);

        System.out.print("Enter your lottery pick (three digits): ");
        int guess = input.nextInt();

        lotteryNumber.add(lottery / 10 % 10);
        lotteryNumber.add(lottery % 10);
        lotteryNumber.add(lottery / 100);

        ArrayList<Integer> guessNumber = new ArrayList<>();
        guessNumber.add(guess / 10 % 10);
        guessNumber.add(guess % 10);
        guessNumber.add(guess / 100);

        System.out.println("The lottery number is " + lottery);

        guessNumber.forEach(e -> {
            if (lotteryNumber.contains(e))
                counter++;
        });

        if (guess == lottery)
            System.out.println("Exact match: you win $12,000");
        else if (counter == 3)
            System.out.println("Match all digits: you win $5,000");
        else if (counter == 2)
            System.out.println("Match two digits: you win $3,000");
        else if (counter == 1)
            System.out.println("Match one digit: you win $2,000");
        else
            System.out.println("Sorry, no match");
    }
}
