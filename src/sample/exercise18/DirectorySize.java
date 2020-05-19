package sample.exercise18;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DirectorySize {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file) {
        long size = 0; // Store the total size of all files
        Queue<File> files = new LinkedList<>();
        files.add(file);
        while (!files.isEmpty()) {
            final File file1 = files.remove();
            if (file1.isDirectory()) {
                File[] tempFiles = file1.listFiles(); // All files and subdirectories
                if (tempFiles != null)
                    for (File fileInScope : tempFiles)
                        files.offer(fileInScope);
            } else { // Base case
                size += file1.length();
            }
        }
        return size;
    }
}
