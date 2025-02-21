package leetcode.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

public class Task101 {
    //итеративный метод
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.pop();
            TreeNode rightNode = queue.pop();

            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null) {
                return false;
            }

            if (leftNode.value != rightNode.value) {
                return false;
            }
            //важен порядок добавления в очередь
            queue.push(leftNode.left);
            queue.push(rightNode.right);
            queue.push(leftNode.right);
            queue.push(rightNode.left);
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    //рекурсивный метод
    public boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }

        return (leftNode.value == rightNode.value)
                && isMirror(leftNode.right, rightNode.left)
                && isMirror(leftNode.left, rightNode.right);
    }
}


class Test101 {
    public static void main(String[] args) {
        Task101 t = new Task101();
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(t.isSymmetric(root));
    }
}
