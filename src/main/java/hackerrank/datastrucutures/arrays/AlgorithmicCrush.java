package hackerrank.datastrucutures.arrays;

import java.util.*;

/**
 * Created by admin on 08/03/2017.
 */
public class AlgorithmicCrush {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = Integer.parseInt(in.next().trim());
        long[][] ops = new long[m][3];
        for (int i = 0; i < m; i++) {
            ops[i][0] = in.nextLong();
            ops[i][1] = in.nextLong();
            ops[i][2] = in.nextLong();
        }
        System.out.println(result1(n, ops));
    }

    private static long result1(int n, long[][] ops) {
        int k = 0;
        TreeMap<Integer, Long> treeMap = new TreeMap<>();
        treeMap.put(n + 1, 0L);
        for (int i = 0; i < ops.length; i++) {
            Integer from = (int) ops[i][0];
            Integer to = (int) ops[i][1];
            Long val = ops[i][2];
                Map.Entry<Integer, Long> fromCeilingEntry = treeMap.ceilingEntry(from);
                int key = fromCeilingEntry.getKey();
                Long value = fromCeilingEntry.getValue();
                treeMap.put(from, value);
                if (key < to) {
                    SortedMap<Integer, Long> fromToSubMap = treeMap.subMap(from + 1, to+1);
                    for (Integer keys : fromToSubMap.keySet()) {
                        treeMap.put(keys, treeMap.get(keys) + val);
                    }
                }
            Map.Entry<Integer, Long> toCeilingEntry = treeMap.ceilingEntry(to + 1);
            treeMap.put(to + 1, toCeilingEntry.getValue() + val);
            k++;
        }
        Long max = treeMap.values().stream().max(Long::compare).get();
        return max;
    }

    private static long result(int n, long[][] ops) {
        long[] longs = new long[n];
        for (int i = 0; i < ops.length; i++) {
            for (int j = (int) ops[i][0] - 1; j < ops[i][1]; j++) {
                longs[j] += ops[i][2];
            }
        }
        Arrays.sort(longs);
        return longs[n - 1];
    }
}
