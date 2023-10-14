import java.util.Scanner;

public class StringSandbox {
    public static void main(String[] args) {
        System.out.println(findNextToLargest("15 32 7 98 1"));
    }

    public static int findNextToLargest(String text) {
        Scanner scanner = new Scanner(text);
        scanner.useDelimiter(" ");
        int largest = 0;
        int secondLargest = 0;

        while (!scanner.nextLine().equals("")) {
            if (largest < Integer.parseInt(scanner.nextLine())) {
                secondLargest = largest;
                largest = Integer.parseInt(scanner.nextLine());
            }
        }

        return secondLargest;
    }

    public static void forLoopTest() {
        String str1 = "Test and Foo";
        String str2 = "Foo";
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            System.out.println(i);
        }
    }
}
