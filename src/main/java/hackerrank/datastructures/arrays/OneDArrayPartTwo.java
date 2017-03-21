package hackerrank.datastructures.arrays;

import java.util.Scanner;

public class OneDArrayPartTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        int[][] arrays = new int[tests][];
        for (int i = 0; i < tests; i++) {
            int n = in.nextInt();
            int jump = in.nextInt();
            arrays[i] = new int[n + 1];
            arrays[i][0] = jump;
            for (int k = 1; k < n+1; k++) {
                arrays[i][k] =in.nextInt();
            }
        }
        for (int i = 0; i < tests; i++) {
            System.out.println(possible(arrays[i]));
        }
    }

    private static String possible(int[] array) {
        int jump = array[0];
        int curMaxWall = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] == 1){
                curMaxWall++;
                if(curMaxWall >= jump){
                    return "NO";
                }
            }
            else {
                if(curMaxWall == 0) {
                    if((i+jump)>=array.length){
                        return "YES";
                    }
                    continue;
                }
                if(i <= jump || array[i-jump] == 1){
                    if(i<array.length-1 && (array[i+1]==1 || ((i+1 > jump)&&(array[i+1-jump]==1)))){
                        array[i] = 1;
                    }
                    curMaxWall++;
                    if(curMaxWall >= jump){
                        return "NO";
                    }
                    continue;
                }
                curMaxWall=0;
                if((i+jump)>=array.length){
                    return "YES";
                }
            }
        }
        return "YES";
    }
}
