package hackerrank.datastructures;

import java.util.*;

public class JavaDequeue {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int curSize = 0;
        int maxSize = 0;

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (i >= m) {
                Integer last = (Integer) deque.pollLast();
                int lastVal = map.get(last);
                if (lastVal == 1) {
                    curSize--;
                }
                map.put(last, lastVal - 1);
            }
            deque.addFirst(num);
            if (!map.containsKey(num) || map.get(num) == 0) {
                curSize++;
                map.put(num, 1);
                if(curSize > maxSize){
                    maxSize = curSize;
                }
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        System.out.println(maxSize);
    }
}
