//Если задан целочисленный массив nums и целое число k, верните true, если в массиве есть два различных индекса i и j,
//такие что nums[i] == nums[j] и abs(i - j) <= k.

//Пример 1:
//Ввод: nums = [1,2,3,1], k = 3
// Вывод: true

//Пример 2:
//Ввод: nums = [1,0,1,1], k = 1
// Вывод: true

//Пример 3:
//Ввод: nums = [1,2,3,1,2,3], k = 2
// Вывод: false


package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //Sliding window
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}


class Test219 {
    public static void main(String[] args) {
        Task219 t = new Task219();
        int[] nums = {99, 99};
        int k = 2;
        System.out.println(t.containsNearbyDuplicate(nums, k));
    }
}

