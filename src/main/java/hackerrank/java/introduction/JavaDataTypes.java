package hackerrank.java.introduction;

import java.math.BigInteger;
import java.util.Scanner;


public class JavaDataTypes {
    public static void main(String[] args) {
        final String[] INT_STRINGS = { "* long", "* int", "* short","* byte"};
        final String CAN = " can be fitted in:";
        final String CANNOT = " can't be fitted anywhere.";

        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.next().trim());
        BigInteger[] ints = new BigInteger[t];
        for (int i = 0; i < t; i++) {
            ints[i] = in.nextBigInteger();
        }
        int[] results = results(ints);
        for (int i = 0; i < t; i++) {
            int result = results[i];
            if(result == 0){
                System.out.println(ints[i] + CANNOT);
            }
            else {
                System.out.println(ints[i] + CAN);
                for (int j = result - 1; j >= 0; j--) {
                    System.out.println(INT_STRINGS[j]);
                }
            }
        }
    }

    private static int[] results(BigInteger[] ints) {
        int[] results = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            if(ints[i].compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0
                    || ints[i].compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0){
                results[i] = 0;
                continue;
            }
            long l = ints[i].longValue();
            if(l > Integer.MAX_VALUE || l < Integer.MIN_VALUE){
                results[i] = 1;
                continue;
            }
            if(l > Short.MAX_VALUE || l < Short.MIN_VALUE){
                results[i] = 2;
                continue;
            }
            if(l > Byte.MAX_VALUE || l < Byte.MIN_VALUE){
                results[i] = 3;
                continue;
            }
            results[i] = 4;
        }
        return results;
    }
}
