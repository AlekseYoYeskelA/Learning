package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Прямой обход (preorder traversal)
public class Task144 {
    //Рекурсивный метод
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.value);
            helper(root.left, res);
            helper(root.right, res);
        }
    }
    //стек:
    //res: 1, 2, 4, 5, 6, 7, 3, 8, 9

    //итеративный метод с использованием стека
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {                   //если дерево пустое, возвращаем пустой список
            return result;
        }
        stack.push(root);                     //записываем в стек корень дерева (в данном случае 1)
        while (!stack.isEmpty()) {            //если стек не пустой
            TreeNode current = stack.pop();   //удаляем верхнее значение из стека и присваиваем его текущему узлу
            result.add(current.value);        //записываем значение текущего узла в список

            if (current.right != null) {      //если есть правый потомок
                stack.push(current.right);    //записываем его в стек
            }

            if (current.left != null) {       //если есть левый потомок
                stack.push(current.left);     //записываем его в стек
            }
        }
        return result;                        //возвращаем результат
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                result.add(node.value);
                node = node.right;
            } else {
                TreeNode previous = node.left;
                while (previous.right != null && previous.right != node) {
                    previous = previous.right;
                }

                if (previous.right == null) {
                    result.add(node.value);
                    previous.right = node;
                    node = node.left;
                } else {
                    previous.right = null;
                    node = node.right;
                }
            }
        }
        return result;
    }
}


class Test144 {
    public static void main(String[] args) {
        Task144 t = new Task144();
        //[1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(7))),
                        new TreeNode(3,
                                null,
                                new TreeNode(8,
                                        new TreeNode(9),
                                        null)));

        System.out.println(t.preorderTraversal1(root)); //Output: [1,2,4,5,6,7,3,8,9]
    }
}
