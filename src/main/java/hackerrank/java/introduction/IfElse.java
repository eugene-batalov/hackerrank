package hackerrank.java.introduction;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next().trim());
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", n, i, n*i);
        }
    }
}
