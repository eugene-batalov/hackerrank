package hackerrank.java.advanced.visitorpattern;

class FancyVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        //implement this
        return Math.abs(result);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 != 0) return;
        result += node.getValue();
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() != Color.GREEN) return;
        result -= leaf.getValue();
        //implement this
    }
}