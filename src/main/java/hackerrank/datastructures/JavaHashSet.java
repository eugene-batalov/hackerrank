package hackerrank.datastructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class JavaHashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        TreeMap<String, Set<String>> treeMap = new TreeMap<>();
        int uniques = 0;
        for (int i = 0; i < t; i++) {
            String l = pair_left[i];
            String r = pair_right[i];
            if (treeMap.containsKey(l)) {
                Set<String> set = treeMap.get(l);
                if (set != null) {
                    if (!set.contains(r)) {
                        set.add(r);
                        uniques++;
                    }
                } else {
                    set = new HashSet<>();
                    set.add(r);
                    uniques++;
                }
            } else {
                Set<String> set = new HashSet<>();
                set.add(r);
                treeMap.put(l, set);
                uniques++;
            }
            System.out.println(uniques);
        }
    }
}
