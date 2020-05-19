package sample.exercise21;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        selectionSort(list1, new GeometricObjectComparator());
        System.out.println(Arrays.toString(list1));

        String[] list2 = {"red", "blue", "green", "yellow", "orange",
                "pink"};
        selectionSort(list2, Comparator.comparing(e1 -> e1.charAt(e1.length() - 1)));
        System.out.println(Arrays.toString(list2));
    }

    public static <E> void selectionSort(E[] list,
                                         Comparator<? super E> comparator) {
        Arrays.sort(list, comparator);
    }
}
