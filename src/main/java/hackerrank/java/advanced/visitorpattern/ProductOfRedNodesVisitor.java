package hackerrank.java.advanced.visitorpattern;

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    final long M = 1000000007;
    public int getResult() {
        //implement this
        return (int)(result == 0? 1 : result % M);
    }

    public void visitNode(TreeNode node) {
        if(node.getColor() == Color.GREEN) return;
        result *= node.getValue();
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.GREEN) return;
        result *= leaf.getValue();
        //implement this
    }
}
