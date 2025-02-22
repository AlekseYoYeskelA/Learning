//Вам дан массив целых чисел nums и целое число k.
//Добавьте к nums k уникальных положительных целых чисел, которые не встречаются в nums, так,
//чтобы полученная общая сумма была минимальной. Верните сумму k целых чисел, добавленных к nums.
//
//Example 1:
//
//Input: nums = [1,4,25,10,25], k = 2
//Output: 5
//Explanation: The two unique positive integers that do not appear in nums which we append are 2 and 3.
//The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the minimum.
//The sum of the two integers appended is 2 + 3 = 5, so we return 5.
//Example 2:
//
//Input: nums = [5,6], k = 6
//Output: 25
//Explanation: The six unique positive integers that do not appear in nums which we append are 1, 2, 3, 4, 7, and 8.
//The resulting sum of nums is 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36, which is the minimum.
//The sum of the six integers appended is 1 + 2 + 3 + 4 + 7 + 8 = 25, so we return 25.
//
// Подсказка 1
//K наименьших чисел, которые не встречаются в nums, дадут минимальную сумму.
//
// Подсказка 2
//Напомним, что сумма первых n положительных чисел равна n * (n+1) / 2.
//
// Подсказка 3
//Инициализируйте ответ как сумму от 1 до k. Затем скорректируйте ответ в зависимости от значений в числах


package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Task2195 {
    public static long minimalKSum(int[] nums, int k) {
        Set<Integer> treeSet = new TreeSet<>();
        long sum = 0;
        for (int num : nums) {
            if (!treeSet.contains(num) && num<=k) {
                k++;
                sum += num;
            }
            treeSet.add(num);
        }
        long res = k * (k + 1) / 2 - sum;
        return res;
    }
}

class TestTask2195 {
    public static void main(String[] args) {
//        int[] nums = {53,41,90,33,84,26,50,32,63,47,66,43,29,88,71,28,83};
//        int k = 76;
        int[] nums = {1,4,25,10,25};
        int k = 2;
        System.out.println(Task2195.minimalKSum(nums, k)); //3444
    }
}