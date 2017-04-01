package hackerrank.datastructures.arrays;

import java.util.Scanner;

public class OneDArrayPartTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        int[][] arrays = new int[tests][];
        for (int i = 0; i < tests; i++) {
            int number = in.nextInt();
            int jump = in.nextInt();
            arrays[i] = new int[number + 1];
            arrays[i][0] = jump;
            for (int k = 1; k < number + 1; k++) {
                arrays[i][k] = in.nextInt();
            }
        }
        for (int i = 0; i < tests; i++) {
            System.out.println(possible2(arrays[i]));
        }
    }

    private static int markNext(int[] array, int position, int jump) {
        if (((position > 0) && (array[position - 1] == -1))
                || ((position < (array.length - 1)) && (array[position + 1] == -1))
                || ((position >= jump) && (array[position - jump] == -1))) {
            array[position] = -1;
            if ((position > 0)
                    && (array[position - 1] == 0)) {
                array[position - 1] = -1;
            }
            if ((position < (array.length - 1))
                    && (array[position + 1] == 0)) {
                array[position + 1] = -1;
            }
            if ((position < (array.length - jump))
                    && (array[position + jump] == 0)) {
                array[position + jump] = -1;
            }
            return -1;
        }
        if (((position > 0) && (array[position - 1] == 1))
                && ((position < (array.length - 1)) && (array[position + 1] == 1))
                && ((position >= jump) && (array[position - jump] == 1))) {
            array[position] = 1;
            return 1;
        }
        return 0;
    }

    private static String possible2(int[] array) {
        int jump = array[0];
        int curMaxWall = 0;
        array[0] = 1;
        array[1] = -1;
        boolean zeroExist;
        for (int i = 0; i < 3; i++) {
            zeroExist = false;
            for (int j = 1; j < array.length; j++) {
                int result = array[j];
                if (result == 0) {
                    result = markNext(array, j, jump);
                }
                if (result == 0) {
                    zeroExist = true;
                }
                if (result == -1) {
                    curMaxWall = 0;
                    if ((j + jump) > array.length) {
                        return "YES";
                    }
                }
                if (result == 1) {
                    curMaxWall++;
                    if (curMaxWall >= jump) {
                        return "NO";
                    }
                }
            }
            if (!zeroExist) {
                return "NO";
            }
        }
        return "YES";
    }

    private static String possible(int[] array) {
        int jump = array[0];
        int curMaxWall = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                curMaxWall++;
                if (curMaxWall >= jump) {
                    return "NO";
                }
            } else {
                if (curMaxWall == 0) {
                    if ((i + jump) >= array.length) {
                        return "YES";
                    }
                    continue;
                }
                if (i <= jump || array[i - jump] == 1) {
                    if (i < array.length - 1 && (array[i + 1] == 1 || ((i + 1 > jump) && (array[i + 1 - jump] == 1)))) {
                        array[i] = 1;
                    }
                    curMaxWall++;
                    if (curMaxWall >= jump) {
                        return "NO";
                    }
                    continue;
                }
                curMaxWall = 0;
                if ((i + jump) >= array.length) {
                    return "YES";
                }
            }
        }
        return "YES";
    }
}
