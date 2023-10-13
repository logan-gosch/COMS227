package lab5;

import java.util.Scanner;

public class StaticLoops {

    public static String initials(String text) {
        Scanner scanner = new Scanner(text);
        String initals = "";
        while (scanner.hasNext()) {
            initals += scanner.next().charAt(0);
        }
        return initals;
    }

    public static int firstVowel(String text) {
        for (int i = 0; i < text.length(); ++i) {
            if ("aeiouAEIOU".indexOf(text.charAt(i)) >= 0) {
                return i;
            }
        }
        return -1;
    }

}
