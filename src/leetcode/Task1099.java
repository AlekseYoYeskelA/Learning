package leetcode;//Учитывая массив nums целых чисел и целое число k, верните максимальное значение sum,
// которое существует i < j с nums[i] + nums[j] = sum и sum < k.
// Если нет i, j существуют удовлетворяющие этому уравнению, верните -1.

import java.util.Arrays;

public class Task1099 {
    public static int twoSumLessThanK(int[] nums, int k) {
        int sol = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k) {
                    sol = maxSum(sol, sum);
                    //sol =Math.max(sol, sum);
                }
            }
        }
        return sol;
    }

    public static int twoSumLessThanK2(int[] nums, int k) {
        Arrays.sort(nums);
        int sol = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                sol = maxSum(sol, sum);
                left++;
            } else {
                right--;
            }
        }
        return sol;
    }

    public static int maxSum(int max, int sum) {
        if (max > sum) {
            return max;
        }
        return sum;
    }


    //    Подсчитайте каждый элемент, используя массив count.
//
//    Установите lo число на ноль, а hi- на 1000.
//
//    Хотя lo меньше или равно hi :
//
//    Если lo + hi больше k или count[hi] == 0:
//    Декремент hi.
//    Еще:
//    Если count[lo]больше 0(когда lo < hi) или 1 (когда lo == hi):
//    Отслеживайте максимум lo + hi в результате answer.
//    Приращение lo.
//    Верните результат answer.
//

//    Count each element using the array count.
//
//    Set the lo number to zero, and hi - to 1000.
//
//    While lo is smaller than, or equals hi:
//
//    If lo + hi is greater than k, or count[hi] == 0:
//    Decrement hi.
//    Else:
//    If count[lo] is greater than 0 (when lo < hi), or 1 (when lo == hi):
//    Track maximum lo + hi in the result answer.
//    Increment lo.
//    Return the result answer.

    public static int twoSumLessThanK3(int[] nums, int k) {
        int answer = -1;
        //тк диапазон входных значений ограничен 0...1000, создаем массив для подсчета каждого элемента
        int[] count = new int[21];
        for (int num : nums) {
            count[num]++; //значение входного массива nums = индекс массива count
        }
        int low = 0;  //минимальное значение
        int high = 20; //максимальное значение
        while (low <= high) {
            if (low + high >= k || count[high] == 0) {
                high--;
            } else {
                if (count[low] > (low < high ? 0 : 1)) {
                    answer = Math.max(answer, low + high);
                }
                low++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(twoSumLessThanK3(new int[]{3, 11, 8, 7, 16, 11, 19, 9, 1}, 23));
    }
}

