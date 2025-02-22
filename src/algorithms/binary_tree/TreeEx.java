package algorithms.binary_tree;

import algorithms.stack.SimpleQueue;
import algorithms.stack.SimpleStack;

public class TreeEx {
    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));
        System.out.println("Summ of Tree: " + Tree.sumWide(root));
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int sumTree() {
            int sum = value;

            if (left != null) {
                sum += left.sumTree();
            }
            if (right != null) {
                sum += right.sumTree();
            }
            return sum;
        }

        public int sumRecursive(Tree root) {
            int sum = root.value;

            if (root.left != null) {
                sum += root.sumRecursive(root.left);
            }
            if (root.right != null) {
                sum += root.sumRecursive(root.right);
            }
            return sum;
        }

        public static int sumDeep(Tree root) {
            SimpleStack<Tree> stack = new SimpleStack<>(); //стэк для обхода дерева в глубину
            stack.push(root);
            int sum = 0;

            while (!stack.isEmpty()) {
                Tree node = stack.pop();
                System.out.println(node.value);
                sum += node.value;

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return sum;
        }

        public static int sumWide(Tree root) {
            SimpleQueue<Tree> queue = new SimpleQueue<>(); //очередь для обхода дерева в ширину
            queue.add(root);
            int sum = 0;

            while (!queue.isEmpty()) {
                Tree node = queue.remove();
                System.out.println(node.value);
                sum += node.value;

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            return sum;
        }
    }
}
