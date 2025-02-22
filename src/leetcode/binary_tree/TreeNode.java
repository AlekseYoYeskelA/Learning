package leetcode.binary_tree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    //конструктор для листа дерева (узел, не имеющий потомков)
    TreeNode(int value) {
        this.value = value;
    }

    //конструктор для узла дерева
    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
