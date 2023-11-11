package lab7;

public class CountPatterns {
    public static void main(String[] args) {
        System.out.println(countPattern(10));
    }

    public static int countPattern(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return countPattern(n - 1) + countPattern(n - 3);
    }
}
