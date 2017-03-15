package hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by admin on 13/03/2017.
 */
public class Introduction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next().trim();
        String b = in.next().trim();
        System.out.println(a.length() + b.length());
        System.out.println((a.compareTo(b) > 0) ? "Yes" : "No");
        String capA = a.substring(0, 1).toUpperCase() + a.substring(1);
        String capB = b.substring(0, 1).toUpperCase() + b.substring(1);
        System.out.println(capA + " " + capB);
    }
}
