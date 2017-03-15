package hackerrank.java.strings;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 13/03/2017.
 */
public class Anagrams {
    static boolean isAnagram(String a, String b) {
        String aSorted = java.util.stream.Stream.of(a.toLowerCase().split("")).sorted().collect(java.util.stream.Collectors.joining());
        String bSorted = java.util.stream.Stream.of(b.toLowerCase().split("")).sorted().collect(java.util.stream.Collectors.joining());
        return aSorted.equals(bSorted);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
