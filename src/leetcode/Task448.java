//Если задан массив nums из n целых чисел, где nums[i] находится в диапазоне [1, n],
// верните массив всех целых чисел в диапазоне [1, n], которые не встречаются в nums.

//Продолжение: Можно ли сделать это без дополнительного пространства и во O(n)время выполнения?
//Вы можете предположить, что возвращаемый список не считается дополнительным пространством.

//Constraints:
//
//n == nums.length
//1 <= n <= 10^5
//1 <= nums[i] <= n

package leetcode;

import java.util.*;

public class Task448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){ //проходим по массиву nums и записываем в set уникальные элементы массива (повторяющиеся элементы будут перезаписаны)
            set.add(nums[i]);
        }
        List <Integer> list = new ArrayList<>();
        for(int i = 1; i<=nums.length; i++){ //начинаем цикл с i=1, тк в условии 1 <= n <= 10^5
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
