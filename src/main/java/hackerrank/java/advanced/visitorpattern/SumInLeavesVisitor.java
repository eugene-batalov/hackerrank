package hackerrank.java.advanced.visitorpattern;

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        //implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        result+=leaf.getValue();
        //implement this
    }
}
