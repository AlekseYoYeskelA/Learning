package leetcode.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Task114 {
    public void flatten(TreeNode root) {
        //проверка на null
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}

class Test114 {
    public static void main(String[] args) {
        Task114 t = new Task114();
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)),
                new TreeNode(5,
                        null, new TreeNode(6)));

        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = null;
        t.flatten(root);
        System.out.println(root); // [1,null,2,null,3,null,4,null,5,null,6]
    }
}


