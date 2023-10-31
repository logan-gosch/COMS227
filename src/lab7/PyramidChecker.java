package lab7;

public class PyramidChecker {
    public static void main (String[] args) {
        System.out.println(getPyramidCount(5));
    }

    public static int getPyramidCount(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * n + (getPyramidCount(n - 1));
        }
    }
}
