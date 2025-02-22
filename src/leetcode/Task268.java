package leetcode;

import java.util.Arrays;

public class Task268 {
    public int findNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) > 1) {
                return nums[i] - 1;
            }
        }
        return -1;
    }

    public int findNumber1(int[] nums) {
        int n = nums.length;
        int fullSum = n * (n + 1) / 2;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//        }
        int sum = Arrays.stream(nums).sum();
        return fullSum - sum;
    }
}

class Test268 {
    public static void main(String[] args) {
        Task268 t = new Task268();
        int[] nums0 = {0, 1};
        int[] nums = {9, 6, 18, 7, 1, 20, 15, 4, 11, 12, 6, 3, 2, 19, 14, 8, 5, 13, 16, 17};
        System.out.println(t.findNumber1(nums));
    }
}
