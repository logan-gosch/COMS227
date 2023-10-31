package lab7;

public class CountPatterns {
    public static void main(String[] args) {
        System.out.println(countPattern(100));
    }

    public static int countPattern(int n) {
        if (n < 3) {
            return 1;
        } else {
            int count = 1;
            return count + countPattern(n - 1);
        }
    }
}
