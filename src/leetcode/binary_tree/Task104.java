package leetcode.binary_tree;


import java.util.*;

public class Task104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);


        return Math.max(leftDepth, rightDepth) + 1;
    }

    //обход в глубину(DFS) с помощью стека
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();

        int maxDepth = 1;
        stack.offer(root);
        depths.offer(maxDepth);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pollLast();
            int currentDepth = depths.pollLast();
            maxDepth = Math.max(currentDepth, maxDepth);

            if (current.right != null) {
                stack.offer(current.right);
                depths.offer(currentDepth + 1);
            }

            if (current.left != null) {
                stack.offer(current.left);
                depths.offer(currentDepth + 1);
            }
        }
        return maxDepth;
    }

    //обход в ширину (BFS) с помощью очереди
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int quSize = queue.size();
            for (int i = 0; i < quSize; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++; //прибавляем глубину при каждом переходе на новый уровень
        }
        return depth;
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(10);
        return root;
    }
}

class Task104Test {
    public static void main(String[] args) {
        TreeNode root = Task104.createTree();
        System.out.println("Максимальная глубина дерева: " + Task104.maxDepth2(root));
    }
}