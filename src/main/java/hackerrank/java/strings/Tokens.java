package hackerrank.java.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Tokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String[] tokens = s.split("[ !,?._'@]+");
        if(tokens.length >0 && tokens[0].equals("")) tokens = new String[0];
        System.out.println(tokens.length);
        Arrays.stream(tokens).forEach(System.out::println);
        scan.close();
    }
}
