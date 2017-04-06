package hackerrank.challenges.sorting;

import java.util.Scanner;

public class Quicksort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] array = new int[num];
        int[] newArray = new int[num];
        int curLess = 0;
        int curAbove = num - 1;
        for (int i = 0; i < num; i++) {
            array[i] = in.nextInt();
        }

        int pivot = array[0];

        for (int i = 1; i < num; i++) {
            if (array[i] < pivot) {
                newArray[curLess++] = array[i];
            } else {
                if (array[i] > pivot) {
                    newArray[curAbove--] = array[i];
                }
            }
        }
        for (int i = curLess; i <= curAbove; i++) {
            newArray[i] = pivot;
        }

        for (int i = 0; i < num; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}
