package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1_1 {
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }




    public static void main(String[] args) {
        int[] nums = {6, 6, 2, 3, 2, 1, 1, 7, 3};
        int[] sol = twoSum3(nums, 13);
        System.out.println(Arrays.toString(sol));
    }
}
