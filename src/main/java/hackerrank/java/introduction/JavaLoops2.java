package hackerrank.java.introduction;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaLoops2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.next().trim());
        int[][] abn = new int[q][3];
        for (int i = 0; i < q; i++) {
            abn[i][0] = in.nextInt();
            abn[i][1] = in.nextInt();
            abn[i][2] = in.nextInt();
        }
        ArrayList<Integer>[] results = results(abn);
        for (ArrayList<Integer> result : results
                ) {
            result.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static ArrayList<Integer>[] results(int[][] abn) {
        ArrayList<Integer>[] results = new ArrayList[abn.length];
        for (int i = 0; i < abn.length; i++) {
            results[i] = result(abn[i]);
        }
        return results;
    }

    private static ArrayList<Integer> result(int[] ints) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(ints[0] + ints[1]);
        for (int i = 1; i < ints[2]; i++) {
            result.add(result.get(i - 1) + (int)Math.pow(2 , i) * ints[1]);
        }
        return result;
    }
}
