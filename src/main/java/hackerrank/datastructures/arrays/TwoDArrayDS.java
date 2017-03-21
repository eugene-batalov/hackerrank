package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * Created by admin on 07/03/2017.
 */
public class TwoDArrayDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] array = getInts(in);
        System.out.println(maxSum(array));
    }

    private static int[][] getInts(Scanner in) {
        int[][] array = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = in.nextInt();
            }
        }
        if (in.hasNext()) {
            in.next().trim();
        }
        return array;
    }

    private static int maxSum(int[][] array) {
        int maxSum = -9 * 9;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = array[i][j] + array[i][j + 1] + array[i][j + 2] +
                        array[i + 1][j + 1] +
                        array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                if (sum > maxSum) maxSum = sum;
            }
        }
        return maxSum;
    }
}
