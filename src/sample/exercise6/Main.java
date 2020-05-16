package sample.exercise6;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++)
            integers.add(i + 1);
        long startTime = System.currentTimeMillis();
        System.out.println(integers.get(10_000_000 - 1));
        System.out.println("Total duration: " + (System.currentTimeMillis()-startTime));

        startTime = System.currentTimeMillis();
        Iterator<Integer> integerIterator = integers.iterator();
        for (int i = 0; i < 10_000_000 - 1; i++)
            integerIterator.next();
        System.out.println(integerIterator.next());
        System.out.println("Total duration: " + (System.currentTimeMillis()-startTime));
    }
}
