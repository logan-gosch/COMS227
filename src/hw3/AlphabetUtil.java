package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import hw3.api.Direction;
import hw3.api.ShiftDescriptor;
import hw3.api.TileInfo;

/**
 * @author Logan Gosch
 */

/**
 * Utility class containing some elements of the basic logic for
 * performing moves in the game AlphabetSoup.
 */
public class AlphabetUtil {
    /**
     * Constructor does nothing, since this object is stateless.
     */
    public AlphabetUtil() {
        // do nothing
    }

    /**
     * Returns the result of merging the two given tile values, or zero
     * if they can't be merged.  The rules are: two values can be merged
     * if they are the same, and are not zero.  The resulting value of a
     * merge is always the current value plus 1.
     *
     * @param a given tile value
     * @param b given tile value
     * @return result of merging the two values, or zero if no merge is possible
     */
    public int findMergedValue(int a, int b) {
        if (a != 0 && a == b) {
            return a + 1;
        }
        return 0;
    }

    /**
     * Returns the score for a single tile. If the given value is
     * greater than zero, the result is three to the power (value - 1).
     * (For example, if the given value is 4, the method returns 27.)
     * Otherwise the method returns zero.
     *
     * @param value tile value for which to compute the score
     * @return score for the given tile value
     */
    public int getScoreForOneTile(int value) {
        if (value > 0) {
            return (int) Math.round(Math.pow(3.0, value - 1));
        }
        return 0;
    }

    /**
     * Generate a new tile value using the given instance
     * of Random.  Values generated are either 1 or 2,
     * with equal probability.
     *
     * @param rand random number generator to use
     * @return the value 1 or 2, with equal probability
     */
    public int randomNewTileValue(Random rand) {
        return rand.nextInt(2) + 1;
    }

    /**
     * Shifts the array elements to the left according to the rules of the
     * AlphabetSoup game. This method only operates on a one-dimensional array
     * of integers representing the tile values in one row or column,
     * and it only shifts to the left.
     * The AlphabetSoup class can use this method to shift a row or column, in any
     * direction, by copying that row or column, either forward or backward,
     * into a temporary one-dimensional array to be passed to this method.
     * The rules are that if there is a pair of adjacent cells
     * that can be merged (according to the method <code>findMergedValues()</code>),
     * and it has no empty (zero) cells to its left,
     * then the leftmost such pair of cells is merged and everything to
     * its right is shifted left by one cell. Otherwise, if there is an empty
     * cell, then everything to the right of the leftmost empty cell is
     * shifted left by one cell. Otherwise, the array is unmodified and
     * an empty list is returned.
     * <p>
     * The new value for a pair of merged cells
     * is determined by the method <code>findMergedValues()</code>.
     * The method returns a list of ShiftDescriptor objects representing
     * the moved cells.  All returned ShiftDescriptor objects will have
     * unspecified row/column and direction (typically filled in later by
     * the associated AlphabetSoup instance).  The list of returned
     * descriptor objects is in no particular order.
     *
     * @param arr array to be shifted
     * @return list of all moves and/or merges performed in the shift
     */
    public ArrayList<ShiftDescriptor> doShift(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i != arr.length - 1) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                break;

            } else if (i != arr.length - 1 && findMergedValue(arr[i], arr[i + 1]) != 0) {
                arr[i] = findMergedValue(arr[i], arr[i + 1]);
                for (int j = i + 1; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                break;

            }
        }
        return null;

    }

}
