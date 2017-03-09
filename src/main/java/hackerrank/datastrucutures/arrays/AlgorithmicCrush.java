package hackerrank.datastrucutures.arrays;

import java.util.*;

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
        System.out.println(result(n, ops));
    }

    private static long result(int n, long[][] ops) {
        Long max = 0L;
        TreeMap<Integer, Long> treeMap = new TreeMap<>();
        treeMap.put(n + 1, 0L);
        for (long[] op : ops) {
            Integer from = (int) op[0];
            Integer to = (int) op[1];
            Long operationVal = op[2];
            Map.Entry<Integer, Long> fromCeilingEntry = treeMap.ceilingEntry(from);
            Integer key = fromCeilingEntry.getKey();
            Long fromCeilingValue = fromCeilingEntry.getValue();
            treeMap.put(from, fromCeilingValue);
            if (key < to) {
                SortedMap<Integer, Long> fromToSubMap = treeMap.subMap(from + 1, to + 1);
                for (Map.Entry<Integer, Long> entry : fromToSubMap.entrySet()) {
                    Integer entryKey = entry.getKey();
                    Long updatedValue = entry.getValue() + operationVal;
                    treeMap.put(entryKey, updatedValue);
                    if (updatedValue > max) {
                        max = updatedValue;
                    }
                }
            }
            Map.Entry<Integer, Long> toCeilingEntry = treeMap.ceilingEntry(to + 1);
            Long updatedValue = toCeilingEntry.getValue() + operationVal;
            if (updatedValue > max) {
                max = updatedValue;
            }
            treeMap.put(to + 1, updatedValue);
            Map.Entry<Integer, Long> toFloorEntry = treeMap.floorEntry(to);
            if (toFloorEntry.getValue().equals(updatedValue)) {
                treeMap.remove(toFloorEntry.getKey());
            }
        }
        return max;
    }

    private static long resultSlow(int n, long[][] ops) {
        long[] longs = new long[n];
        for (long[] op : ops) {
            for (int j = (int) op[0] - 1; j < op[1]; j++) {
                longs[j] += op[2];
            }
        }
        Arrays.sort(longs);
        return longs[n - 1];
    }
}
