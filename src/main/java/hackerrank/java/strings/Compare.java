package hackerrank.java.strings;

import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        int subLen = in.nextInt();
        in.close();
        String curSub = string.substring(0, subLen);
        String minSub = curSub;
        String maxSub = curSub;
        for (int i = 0; i <= string.length() - subLen; i++) {
            curSub = string.substring(i, i + subLen);
            if(minSub.compareTo(curSub) > 0) minSub = curSub;
            if(maxSub.compareTo(curSub) < 0) maxSub = curSub;
        }
        System.out.println(minSub);
        System.out.println(maxSub);
    }
}
