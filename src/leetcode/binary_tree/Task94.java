package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Центрированный обход (inorder traversal)
public class Task94 {
    //Рекурсивный метод
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.value);
            helper(root.right, res);
        }
    }

    //стек:
    //результат: 4, 2, 6, 5, 7, 1, 3, 9, 8

    //Итеративный метод с использованием стека (в стек записываются родительские узлы)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();                  //создаем результирующий список
        Stack<TreeNode> stack = new Stack<>();                     //создаем стек, в который будут записываться узлы-родители при обходе
        TreeNode current = root;                                   //ставим указатель текущего узла на корень дерева (в данном случае 1)
        while (current != null || !stack.isEmpty()) {              //пока текущий узел не null и стек не пустой
            if (current != null) {                                 //если узел не null
                stack.push(current);                               //добавляем в стек текущий узел
                current = current.left;                            //двигаем указатель текущего узла на левого потомка
            } else {                                               //если узел null
                current = stack.pop();                             //удаляем последний записанный узел из стека и возвращаем его (двигаем указатель текущего узла обратно на родителя)
                result.add(current.value);                         //записываем значение текущего узла в список
                current = current.right;                           //двигаем указатель текущего узла на правого потомка
            }
        }
        return result;                                             //возвращаем результат
    }

    //Обход Морриса
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        TreeNode previous;
        while (current != null) {
            if (current.left == null) {
                res.add(current.value);
                current = current.right; // move to next right node переходим к следующему правому узлу
            } else { // has a left subtree
                previous = current.left;
                while (previous.right != null) { // find rightmost
                    previous = previous.right;
                }
                previous.right = current; // put cur after the pre node
                TreeNode temp = current; // store cur node
                current = current.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    public TreeNode containsNode(TreeNode root, int target) {
//        while (root != null) {
//            if (target == root.value) {
//                return root;
//            }
//            if (target < root.value) {
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//        return null;
//    }

        while (root != null && target != root.value) {
            root = target < root.value ? root.left : root.right;
        }
        return root;
    }
}


class Test94 {
    public static void main(String[] args) {
        Task94 t = new Task94();
        //[1,2,3,4,5,null,8,null,null,6,7,9]

        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));

        System.out.println(t.containsNode(root1, 2));

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

        System.out.println(t.inorderTraversal1(root)); //Output: [4,2,6,5,7,1,3,9,8]
    }
}

