package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer2 {
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("./story.txt");
        System.out.println(file.exists());          // true if the file exists
        System.out.println(file.getName());         // name of the file
        System.out.println(file.getAbsolutePath()); // absolute path to the file
        System.out.println(file.length());          // size of the file
        Scanner scanner = new Scanner(file);
        int lineCount = 1;

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.print(lineCount + " ");
            System.out.println(line);
            lineCount += 1;
        }
        scanner.close();

        wordsPerLine("src/lab6/story.txt");
    }

    public static void wordsPerLine(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        System.out.println("\nWords per line in " + file.getName());



        while (scanner.hasNextLine()) {
            int numWords = 0;
            String line = scanner.nextLine();

            Scanner temp = new Scanner(line);
            while (temp.hasNext()) {
                numWords++;
                temp.next();
            }
            System.out.println(numWords + " words");

            scanner.nextLine();
        }
        scanner.close();
    }
}
