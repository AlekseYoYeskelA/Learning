package leetcode;

import java.util.Arrays;

public class Task2206 {

    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) {
            return false;
        } // провереяем массив на четность

        Arrays.sort(nums); // сортируем массив по возрастанию

        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        } // проверяем пары на равенство

        return true;
    }

}
class Task2206Test {
    public static void main(String[] args) {
        Task2206 pairsChecker = new Task2206();

        int[] nums = {1,2,2,1};

        boolean canFormPairs = pairsChecker.divideArray(nums);

        System.out.println("Можно ли разделить числа на пары: " + canFormPairs);
    }
}