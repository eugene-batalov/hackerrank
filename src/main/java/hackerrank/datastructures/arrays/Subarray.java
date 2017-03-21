package hackerrank.datastructures.arrays;

import java.util.Scanner;

public class Subarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        System.out.println(negativeSubArrays(ints));
    }

    private static int negativeSubArrays(int[] ints) {
        int number = 0;
        for (int i = 0; i < ints.length; i++) {
            int subSum = ints[i];
            if(subSum < 0) {
                number++;
            }
            for (int j = i + 1; j < ints.length; j++) {
                subSum += ints[j];
                if(subSum < 0) {
                    number++;
                }
            }
        }
        return number;
    }
}
