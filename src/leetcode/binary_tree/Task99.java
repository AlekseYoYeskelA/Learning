package leetcode.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task99 {
    public void swap(TreeNode one, TreeNode two) {
        int tmp = one.value;
        one.value = two.value;
        two.value = tmp;
    }

    //stack:
    //root: n
    //pred: 4
    //node1: 3
    //node2: 2
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node1 = null; //первый неверный узел
        TreeNode node2 = null; //второй неверный узел
        TreeNode pred = null;  //предшественник

        while (!stack.isEmpty() || root != null) {
            //идем вглубь дерева по левой ветке, пока не дойдем до пустого узла (null)
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //если root пустой (null)
            root = stack.pop();
            //если был предшественник и его значение больше текущего(root)
            if (pred != null && root.value < pred.value) {
                node2 = root; // node2 присваиваем текущее значение
                //если node1 пустой, присваиваем ему значение предшественника
                if (node1 == null) {
                    node1 = pred;
                }
            }
            pred = root;
            root = root.right;
        }
        swap(node1, node2); //меняем местами неверные узлы
    }


    //С помощью обхода Морриса
    public void recoverTree1(TreeNode root) {
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode pred = null;
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (pred != null && root.value < pred.value) {
                        node2 = root;
                        if (node1 == null) {
                            node1 = pred;
                        }
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                if (pred != null && root.value < pred.value) {
                    node2 = root;
                    if (node1 == null) {
                        node1 = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(node1, node2);
    }
}


class Test99 {
    public static void main(String[] args) {
        Task99 t = new Task99();
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(1),
                        new TreeNode(2,
                                new TreeNode(3), null));

        t.recoverTree(root);
        System.out.println(root);
    }
}
