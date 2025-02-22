package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Обратный обход (postorder traversal)
public class Task145 {
    //Рекурсивный метод
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.value);
        }
    }

    //Итеративный метод с использованием стека
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {                   //пока стек пустой или корень не пустой:
            if (root != null) {                                      //если корень не пустой:
                stack.push(root);                                    //пишем в стек этот корень
                root = root.left;                                    //двигаемся влево (присваиваем корню его левого потомка)
            } else {                                                 //если корень пустой:
                root = stack.peek();                                 //присваиваем корню верхнее (последнее) значение из стека
                if (root.right == null || root.right == lastNode) {  //если нет правого потомка или обход пришел из правого потомка
                    result.add(root.value);                          //пишем в список значение корня
                    stack.pop();                                     //удаляем из стека верхнее значение
                    lastNode = root;                                 //запоминаем посещенный узел
                    root = null;                                     //обнуляем корень
                } else {                                             //если правый потомок существует и обход пришёл из левого потомка
                    root = root.right;                               //двигаемся вправо (присваиваем корню его правого потомка)
                }
            }
        }
        return result;
    }

    //Обход Морриса (без стека)
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // Create a dummy node to simplify edge cases
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode predecessor = null;
        dummyNode.left = root;
        root = dummyNode;

        // Traverse the tree
        while (root != null) {
            // If the current node has a left child
            if (root.left != null) {
                predecessor = root.left;

                // Find the rightmost node in the left subtree or the thread to the current node
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // Create a thread if it doesn't exist
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // Process the nodes in the left subtree
                    TreeNode node = predecessor;
                    reverseSubtreeLinks(root.left, predecessor);

                    // Add nodes from right to left
                    while (node != root.left) {
                        result.add(node.value);
                        node = node.right;
                    }
                    result.add(node.value); // Add root.left value
                    reverseSubtreeLinks(predecessor, root.left);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // Move to the right child if there's no left child
                root = root.right;
            }
        }

        return result;
    }

    private void reverseSubtreeLinks(TreeNode startNode, TreeNode endNode) {
        if (startNode == endNode) {
            return; // If the start and end nodes are the same, no need to reverse
        }

        TreeNode prev = null;
        TreeNode current = startNode;
        TreeNode next = null;

        // Reverse the direction of the pointers in the subtree
        while (current != endNode) {
            next = current.right;
            current.right = prev;
            prev = current;
            current = next;
        }
        // Reverse the last node
        current.right = prev;
    }
}


class Test145 {
    public static void main(String[] args) {
        Task145 t = new Task145();
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

        System.out.println(t.postorderTraversal1(root)); //Output: [4,6,7,5,2,9,8,3,1]
    }
}
