package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * Created by admin on 07/03/2017.
 */
public class ArraysDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next().trim());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        if(in.hasNext()){
            in.next().trim();
        }
        for (int i = n-1; i >=0; i--) {
            System.out.print(ints[i] + (i == 0? "\n" : " "));
        }
    }
}
