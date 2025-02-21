package leetcode.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task404 {
    public int sumOfLeftLeaves(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int leftSum = 0;

        while (!stack.isEmpty()) {
            root = stack.pop();

            if (isLeaf(root.left)) {
                leftSum += root.left.value;
            }

            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
//                if(root.left.left == null && root.left.right == null){
//                    leftSum += root.left.value;
//                }
                stack.push(root.left);
            }
        }
        return leftSum;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    //работают не все кейсы
//    public int sumOfLeftLeaves1(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        int leftSum = 0;
//
//        while (root != null || !stack.isEmpty()) {
//            if (root != null) {
//                stack.push(root);
//                root = root.left;
//            } else {
//                root = stack.pop();
//                if (root.left == null && !stack.isEmpty()) {
//                    leftSum += root.value;
//                }
//                root = root.right;
//            }
//        }
//        return leftSum;
//    }
}


class Test404 {
    public static void main(String[] args) {
        Task404 t = new Task404();
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));

        TreeNode root1 = new TreeNode(1);
        System.out.println(t.sumOfLeftLeaves(root));
    }
}

