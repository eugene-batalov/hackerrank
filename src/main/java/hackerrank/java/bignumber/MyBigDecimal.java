package hackerrank.java.bignumber;

import java.util.*;

public class MyBigDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();
        TreeMap<java.math.BigDecimal, ArrayList<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        String[] s1 = new String[n];
        for (int i = 0; i < n; i++) {
            java.math.BigDecimal bigDecimal = new java.math.BigDecimal(s[i]);
            if (!treeMap.containsKey(bigDecimal)) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                treeMap.put(bigDecimal, integers);
            } else {
                ArrayList<Integer> integers = treeMap.get(bigDecimal);
                integers.add(i);
            }
            s1[i] = s[i];
        }
        int k = 0;
        for (Map.Entry<java.math.BigDecimal, ArrayList<Integer>> entry : treeMap.entrySet()) {
            ArrayList<Integer> integers = entry.getValue();
            for (Integer integer : integers) {
                s[k] = s1[integer];
                k++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
