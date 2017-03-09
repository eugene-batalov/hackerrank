package hackerrank.datastrucutures.arrays;

import java.util.Scanner;

/**
 * Created by admin on 08/03/2017.
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next().trim());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next().trim();
        }
        int q = Integer.parseInt(in.next().trim());
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = in.next().trim();
        }
        int[] results = results(strings, queries);
        for (int i = 0; i < q; i++) {
            System.out.println(results[i]);
        }

    }

    private static int[] results(String[] strings, String[] queries) {
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    results[i]++;
                }
            }
        }
        return results;
    }
}
