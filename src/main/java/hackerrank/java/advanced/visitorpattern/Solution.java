package hackerrank.java.advanced.visitorpattern;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt();
        int[] vals = new int[nodes];
        for (int i = 0; i < nodes; i++) vals[i] = in.nextInt();
        int[] colors = new int[nodes];
        for (int i = 0; i < nodes; i++) colors[i] = in.nextInt();
        int[][] structure = new int[nodes][2];
        for (int i = 0; i < nodes - 1; i++) {
            structure[i][0] = in.nextInt();
            structure[i][1] = in.nextInt();
        }
        return createTree(vals, colors, structure);
    }

    private static Tree createTree(int[] vals, int[] colors, int[][] structure) {
        int n = vals.length;
        Tree[] nodes = new Tree[n];
        int[] depths = new int[n];
        ArrayList<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < structure.length; i++) {
            children[structure[i][0]].add(structure[i][1]);
        }
        setDepths(depths, structure, 1, 0);
        for (int i = 0; i < n; i++) {
            if (getChildren(structure, i + 1).length > 0) {
                nodes[i] = new TreeNode(vals[i], colors[i] == 0 ? Color.RED : Color.GREEN, depths[i]);
            } else {
                nodes[i] = new TreeLeaf(vals[i], colors[i] == 0 ? Color.RED : Color.GREEN, depths[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] instanceof TreeNode) {
                setChildren(nodes, (TreeNode) nodes[i], structure, i + 1);
            }
        }
        return nodes[0];
    }

    private static void setChildren(Tree[] nodes, TreeNode node, int[][] structure, int nodeIndex) {
        Integer[] children = getChildren(structure, nodeIndex);
        for (int i = 0; i < children.length; i++) {
            int child = children[i];
            node.addChild(nodes[child - 1]);
        }
    }

    private static void setDepths(int[] depths, int[][] structure, int node, int curDepth) {
        Integer[] children = getChildren(structure, node);
        for (int i = 0; i < children.length; i++) {
            int child = children[i];
            depths[child - 1] = curDepth + 1;
            setDepths(depths, structure, child, curDepth + 1);
        }
    }

    private static Integer[] getChildren(int[][] structure, int node) {
        ArrayList<Integer> children = new ArrayList<>();
        for (int i = 0; i < structure.length; i++) {
            if (structure[i][0] == node) children.add(structure[i][1]);
        }
        return children.toArray(new Integer[children.size()]);
        //return Arrays.stream(structure).filter(x -> x[0] == node).mapToInt(x -> x[1]).toArray();
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}