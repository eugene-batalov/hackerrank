package hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by admin on 13/03/2017.
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(in.next());
        if(sb.toString().equals(sb.reverse().toString())) System.out.println("Yes");
        else System.out.println("No");
    }
}
