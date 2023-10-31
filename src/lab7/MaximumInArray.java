package lab7;

public class MaximumInArray {
    public static void main(String[] args) {
        int[] test = {5, 3, 0 , 8, 15};
        int max = maxInArray(test, 0, test.length - 1);
        System.out.println(max);
    }

    public static int maxInArray(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftSide = maxInArray(arr, start, mid);
            int rightSide = maxInArray(arr, mid + 1, end);
            return Math.max(leftSide, rightSide);
        }
    }
}
