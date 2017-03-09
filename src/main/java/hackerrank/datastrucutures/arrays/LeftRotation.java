package hackerrank.datastrucutures.arrays;

import java.util.Scanner;

/**
 * Created by admin on 08/03/2017.
 */
public class LeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = Integer.parseInt(in.next().trim());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        int[] rotated = rotate(ints, d);
        for (int i = 0; i <n; i++) {
            System.out.print(rotated[i] + " ");
        }
    }

    private static int[] rotate(int[] ints, int d) {
        int[] rotated = ints.clone();
        d = d % ints.length;
        if(d == 0) {
            return rotated;
        }
        for (int i = 0; i < rotated.length; i++) {
            if (i+d == rotated.length){
                d -= rotated.length;
            }
            rotated[i] = ints[i + d];
        }
        return rotated;
    }
}
