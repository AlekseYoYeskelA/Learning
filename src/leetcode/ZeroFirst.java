package leetcode;

import java.util.Arrays;

public class ZeroFirst {
    //с перестановкой эл-тов
    public static void zeroFirst(int[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            if (array[low] == 0) {
                low++;
            }

            if (array[high] != 0) {
                high--;
            }

            if (array[low] != 0 && array[high] == 0) {
                swap(array, low, high);
            }
        }
    }

    //с созданием результирующего массива
    public static int[] zeroFirst1(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                result[low++] = array[i];
            } else {
                result[high--] = array[i];
            }
        }
        return result;
    }

    private static void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    public static int[] sortedSqr(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //int idx = nums.length - 1;
        int[] result = new int[nums.length];

        //while (low <= high) {
        for (int i = nums.length-1; i > 0; i--) {
            if (Math.abs(nums[low]) > Math.abs(nums[high])) {
                result[i] = nums[low] * nums[low];
                low++;
            } else {
                result[i] = nums[high] * nums[high];
                high--;
            }
        }
        //idx--;
        return result;
    }
}

class ZeroFirstTest {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0};
        int[] nums = {-4, -1, 0, 3, 10};
        //ZeroFirst.zeroFirst(array);
        int[] result = ZeroFirst.zeroFirst1(array);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(ZeroFirst.sortedSqr(nums)));
    }
}