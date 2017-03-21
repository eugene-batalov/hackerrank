package hackerrank.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nLists = in.nextInt();
        ArrayList<Integer>[] lists = new ArrayList[nLists];
        for (int i = 0; i < nLists; i++) {
            int n = in.nextInt();
            lists[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                lists[i].add(in.nextInt());
            }
        }
        int nQ = in.nextInt();
        int[][] queries = new int[nQ][2];
        for (int i = 0; i < nQ; i++) {
            queries[i][0] = in.nextInt();
            queries[i][1] = in.nextInt();
        }
        for (int i = 0; i < nQ; i++) {
            int nList = queries[i][0] - 1;
            int nElement = queries[i][1];
            if(lists[nList].size() < nElement){
                System.out.println("ERROR!");
            }
            else {
                System.out.println(lists[nList].get(nElement - 1));
            }
        }
    }
}
