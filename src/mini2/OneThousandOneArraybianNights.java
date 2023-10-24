package mini2;

import java.lang.module.FindException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class OneThousandOneArraybianNights
{

    private OneThousandOneArraybianNights()
    {
        // disable instantiation
    }


    public static int findIt(int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 || arr[i] == arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public static String[] removeMultiples(String[] arr) {

        ArrayList<String> copyArray = new ArrayList<>();

        for (String s : arr) {
            if (!copyArray.contains(s)) {
                copyArray.add(s);
            }
        }

        String[] strings = new String[copyArray.size()];
        strings = copyArray.toArray(strings);

        return strings;
    }

    public static int[] condense(int[] arr, int k)
    {
        int position = 0;
        int[] condensedArr = new int[arr.length / k];

        for (int i = 0; i < condensedArr.length; i++) {
            int j = 0;
            while (j < k) {
                condensedArr[i] = condensedArr[i] + arr[(j + position)];
                j++;
            }
            position += k;
        }

        return condensedArr;
    }

    public static void swizzle(int[] arr, int[] swizzler) {
        if (arr.length == swizzler.length) {
            int i;
            int[] copyArr = copyOf(arr, arr.length);

            for (i = 0; i < arr.length; i++) {
                if (swizzler[i] >= arr.length || swizzler[i] < 0) {
                    return;
                }
            }

            for (i = 0; i < arr.length; i++) {
                arr[i] = copyArr[swizzler[i]];
            }
        }

    }

    public static int[] findSwizzlerThatSorts(int[] arr) {
        int[] copyArr = copyOf(arr, arr.length);
        int[] sortedArr = new int[arr.length];
        int i;

        int indexOfSmallest = 0;

        for (i = 0; i < arr.length; i++) {
            int currentSmallest = copyArr[i];
            for (int j = 0; j < arr.length; j++) {
                if (copyArr[j] < currentSmallest) {
                    currentSmallest = copyArr[j];
                    indexOfSmallest = j;
                }
            }
            sortedArr[i] = indexOfSmallest;
            copyArr[indexOfSmallest] = Integer.MAX_VALUE;
        }

        return sortedArr;
    }

    public static int[] findSubsequence(int[] arr, int[] t) {
        int startingPosition = 0;

        int[] sequence = new int[t.length];



        for (int i = 0; i < t.length; i++) {
            for (int j = startingPosition; j < arr.length; j++) {
                if (arr[j] == t[i]) {
                    sequence[i] = j;
                    startingPosition = j + 1;
                    break;
                } else if (j == arr.length - 1 && arr[j] != t[i]) {
                    return new int[0];
                }
            }
        }

        return sequence;
    }

}
