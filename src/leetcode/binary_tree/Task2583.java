package leetcode.binary_tree;

import java.util.*;


public class Task2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        //при обходе в ширину(BFS) ноды храним в очереди(FIFO), а не в стеке(LIFO)
        //List<Long> result = new ArrayList<>();
        Queue<Long> result = new PriorityQueue<>();               //реализация очереди, в которой эл-ты отсортированы
        queue.offer(root);                                        //добавляем в очередь корень

        while (!queue.isEmpty()) {                                //итерируемся, пока очередь не пустая
            long sum = 0;                                         //инициализируем сумму, сумма будет обнуляться при переходе на новый уровень
            int quSize = queue.size();                            //запоминаем размер очереди (кол-во узлов в данном уровне)
            for (int i = 0; i < quSize; i++) {                    //используем цикл, для итерации по уровням дерева
                TreeNode current = queue.poll();                  //достаем первый элемент из очереди и присваиваем его значение текущему узлу
                sum += current.value;                             //прибавляем значение текущего узла к сумме

                if (current.left != null) {                       //если есть левый потомок
                    queue.offer(current.left);                    //записываем его в очередь
                }

                if (current.right != null) {                      //если есть правый потомок
                    queue.offer(current.right);                   //записываем его в очередь
                }
            }
            result.add(sum);                                      //записываем сумму уровня в результирующую очередь

            if (result.size() > k) {                               //оставляем k наибольших sum в результирующей очереди
                result.poll();
            }
        }
        return result.size() < k ? -1 : result.poll();            //если размер результирующей очереди меньше к, возвращаем -1, иначе возвращаем первый эл-т
//        Collections.sort(result);
//        return result.size() < k ? -1 : result.get(result.size() - k);
    }
}

class Test2583 {
    public static void main(String[] args) {
        Task2583 t = new Task2583();
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(8,
                                new TreeNode(2,
                                        new TreeNode(4), new TreeNode(6)), new TreeNode(1)),
                        new TreeNode(9,
                                new TreeNode(3), new TreeNode(7)));

        int k = 2;
        System.out.println(t.kthLargestLevelSum(root, k));
    }
}
