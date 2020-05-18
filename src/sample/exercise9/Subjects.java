package sample.exercise9;

import java.util.ArrayList;
import java.util.Arrays;

public class Subjects {
    public static void main(String[] args) {
        ArrayList<String> subjects1 = new ArrayList<>(Arrays.asList("Chemistry",
                "Mathematics", "Biology", "English"));
        ArrayList<String> subjects2 = new ArrayList<>(Arrays.asList("Biology", "English", "Geography", "Physics"));
        ArrayList<String> temp = (ArrayList<String>) subjects1.clone();
        temp.removeAll(subjects2);
        System.out.println("Only present in first stack: " + temp);
        temp = (ArrayList<String>) subjects2.clone();
        temp.removeAll(subjects1);
        System.out.println("Only present in first stack: " + temp);
        subjects2.retainAll(subjects1);
        System.out.println("Only present in first stack: " + subjects2);
    }
}
