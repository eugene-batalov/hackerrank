package hackerrank.challenges.sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            arrayList.add(in.nextInt());
        }
        partition2(arrayList);
    }


    private static void partition2(ArrayList<Integer> arrayList) {

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();

        Integer pivot = arrayList.get(0);

        for (int i = 0; i < arrayList.size(); i++) {
            Integer next = arrayList.get(i);
            if (next.compareTo(pivot) < 0) {
                less.add(next);
            } else {
                if (next.compareTo(pivot) > 0) {
                    more.add(next);
                } else {
                    equal.add(next);
                }
            }
        }

        if (less.size() > 1) {
            partition2(less);
        }
        if (more.size() > 1) {
            partition2(more);
        }

        arrayList.clear();
        arrayList.addAll(less);
        arrayList.addAll(equal);
        arrayList.addAll(more);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + (i == arrayList.size() - 1 ? "\n" : " "));
        }

    }

    private static void partition(int[] array, int start, int end) {

        int[] newArray = new int[end - start];
        int curLess = 0;
        int curAbove = newArray.length - 1;
        int pivot = array[start];

        for (int i = start + 1; i < newArray.length + start; i++) {
            if (array[i] < pivot) {
                newArray[curLess++] = array[i];
            } else {
                if (array[i] > pivot) {
                    newArray[curAbove--] = array[i];
                }
            }
        }

        for (int i = 0; i < curLess; i++) {
            array[start + i] = newArray[i];
        }
        for (int i = curLess; i <= curAbove; i++) {
            array[start + i] = pivot;
        }
        for (int i = curAbove + 1; i < newArray.length; i++) {
            array[start + i] = newArray[i];
        }

        if (curLess > 1) {
            partition(array, start, start + curLess);
        }

        curAbove++;

        if (start + curAbove < end - 1) {
            partition(array, start + curAbove, end);
        }

        for (int i = start; i < end; i++) {
            System.out.print(Integer.toString(array[i]) + (i == end - 1 ? "\n" : " "));
        }
    }
}
