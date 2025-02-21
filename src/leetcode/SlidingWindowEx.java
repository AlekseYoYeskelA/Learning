package leetcode;

public class SlidingWindowEx {
    public static double maxAverage(int[] nums, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        int res = sum;

        for (int i = length; i < nums.length; i++) {
            sum += nums[i] - nums[i - length];
            res = Math.max(res, sum);
        }
        return (double) res / length;
    }
}

class TestSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int length = 4;
        System.out.println(SlidingWindowEx.maxAverage(nums, length));

    }
}
