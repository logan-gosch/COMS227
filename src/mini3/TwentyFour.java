package mini3;


import mini3.twenty_four_api.IntExpression;

import java.util.ArrayList;

/**
 * Implementation of a search for solutions to a number game inspired
 * by the game "twenty-four".
 */
public class TwentyFour
{
    /**
     * Lists all ways to obtain the given target number using arithmetic operations
     * on the values in the given IntExpression list.  Results in string form are added to
     * the given result list, where the string form of a value is obtained from
     * the toString() of the IntExpression object.
     * <p>
     * Special rules are:
     * 1) you are not required to use all given numbers, and
     * 2) division is integer division, and is only allowed when remainder is zero.
     * For addition and multiplication, a + b and b + a are considered to be
     * distinct solutions, and likewise a * b and b * a are considered as
     * different solutions.  See the pdf for detailed examples.
     * @param list
     *   the values to be used in forming solutions
     * @param target
     *   the target number to be obtained from the values in the list
     * @param results
     *   list in which to place results, as strings
     */
    public static void findSolutions(ArrayList<IntExpression> list, int target, ArrayList<String> results)
    {
        {
            if (list.size() == 1) {
                if (list.get(0).getIntValue() == target) {
                    results.add(list.get(0).toString());
                }
            } else {
                for (IntExpression x : list) {
                    ArrayList<IntExpression> copyList = new ArrayList<>(list);
                    copyList.remove(x);
                    findSolutions(copyList, target, results);
                }
                for  (int i = 0; i < list.size() - 1; i++) {
                    IntExpression x = new IntExpression(list.get(i).getIntValue());
                    IntExpression y = new IntExpression(list.get(i + 1).getIntValue());

                    for (int j = 0; j < 8; j++) {
                        ArrayList<IntExpression> copy = new ArrayList<>(list);
                        copy.remove(i + 1);
                        copy.remove(i);

                        IntExpression z;

                        switch (i) {
                            case(0) -> {
                                z = new IntExpression(x, y, '+');
                                copy.add(z);
                                findSolutions(copy, target, results);
                            }
                            case(1) -> {
                                z = new IntExpression(y, x, '+');
                                copy.add(z);
                                findSolutions(copy, target, results);
                            }
                            case(2) -> {
                                z = new IntExpression(x, y, '*');
                                copy.add(z);
                                findSolutions(copy, target, results);
                            }
                            case(3) -> {
                                z = new IntExpression(y, x, '*');
                                copy.add(z);
                                findSolutions(copy, target, results);
                            }
                            case(4) -> {
                                z = new IntExpression(x, y, '-');
                                copy.add(z);
                                findSolutions(copy, target, results);
                            }
                            case(5) -> {
                                z = new IntExpression(y, x, '-');
                                copy.add(z);
                                findSolutions(copy, target, results);
                            }
                            case(6) -> {
                                if (x.getIntValue() % y.getIntValue() == 0 && y.getIntValue() != 0) {
                                    z = new IntExpression(x, y, '/');
                                    copy.add(z);
                                    findSolutions(copy, target, results);
                                }
                            }
                            case(7) -> {
                                if (y.getIntValue() % x.getIntValue() == 0 && x.getIntValue() != 0) {
                                    z = new IntExpression(y, x, '/');
                                    copy.add(z);
                                    findSolutions(copy, target, results);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}