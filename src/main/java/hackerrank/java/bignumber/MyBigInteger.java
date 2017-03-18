package hackerrank.java.bignumber;

import java.util.Scanner;

public class MyBigInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        java.math.BigInteger bigInteger1 = in.nextBigInteger();
        java.math.BigInteger bigInteger2 = in.nextBigInteger();
        System.out.println(bigInteger1.add(bigInteger2));
        System.out.println(bigInteger1.multiply(bigInteger2));
    }
}
