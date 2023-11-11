package lab7;

import java.io.File;
import java.util.Arrays;

public class CountFiles {
    public static void main(String[] args) {
//        File file = new File("./src/lab7");
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//        System.out.println(file.getName());
//        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println(countFile(new File("./src/hw3")));
    }

    public static int countFile(File file) {
        if (file.isFile()) {
            return 1;
        } else {
            int sum = 0;
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println(f);
                sum += countFile(f);
            }
            return sum;
        }
    }
}
