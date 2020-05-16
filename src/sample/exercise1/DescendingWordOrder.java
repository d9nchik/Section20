package sample.exercise1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DescendingWordOrder {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(
                new File("src/sample/exercise1/words.txt"))))) {
            ArrayList<String> words = new ArrayList<>();
            while (input.hasNext()) {
                String[] tempWords = input.nextLine().split("[\\s]+");
                words.addAll(Arrays.asList(tempWords));
            }
            words.sort(Collections.reverseOrder());
            words.forEach(System.out::println);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
    }
}
