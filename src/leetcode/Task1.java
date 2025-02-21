package leetcode;

public class Task1 {
    public static void twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) { //проверяем условие, пробегаясь по массиву с помощью 2х циклов for
                    System.out.println("[" + i + ", " + j + "]");
                    return; //используем return, чтобы завершился if и следующий блок кода не исполнялся (return - последний statement)
                }
            }
        }
        System.out.println("Нет таких индексов");
    }

    public static void main(String[] args) {
        twoSum(new int[]{2, 6, 5, 3, 7, 9}, 12);
    }
}
