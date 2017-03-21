package hackerrank.datastructures.arrays;

import java.util.*;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.concat;

public class AlgorithmicCrush {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = Integer.parseInt(in.next().trim());
        long[][] ops = new long[m][3];
        for (int i = 0; i < m; i++) {
            ops[i][0] = in.nextLong(); // a
            ops[i][1] = in.nextLong(); // b
            ops[i][2] = in.nextLong(); // k
        }
        System.out.println(resultFast(n, ops));
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

    private static long resultFast(int n, long[][] ops) {
        long max = 0;
        long[] longs = new long[n+1];
        for (long[] op : ops) {
            int iStart = (int) op[0] - 1;
            int iEnd = (int) op[1];
            longs[iStart] += op[2];
            longs[iEnd] -= op[2];
        }
        long currentHigh = 0;
        for (int i = 0; i < n+1; i++) {
            currentHigh += longs[i];
            if (currentHigh > max) {
                max = currentHigh;
            }
        }
        return max;
    }

    private static long resultSlow(int n, long[][] ops) {
        long max = 0;
        long[] longs = new long[n];
        for (long[] op : ops) {
            for (int j = (int) op[0] - 1; j < op[1]; j++) {
                longs[j] += op[2];
                if (longs[j] > max) {
                    max = longs[j];
                }
            }
        }
        return max;
    }

    private static long resultStream(int n, long[][] ops) {
        long[] longs = new long[n];
        for (long[] op : ops) {
            LongStream s = Arrays.stream(longs, 0, (int) op[0] - 1).parallel();
            LongStream s2 = Arrays.stream(longs, (int) op[0] - 1, (int) op[1]).parallel().map(longVal -> longVal + op[2]);
            LongStream s3 = Arrays.stream(longs, (int) op[1], n).parallel();
            longs = concat(s, concat(s2, s3)).toArray();
        }
        Arrays.sort(longs);
        return longs[n - 1];
    }
}
