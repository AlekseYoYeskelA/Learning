package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

// 1929. Concatenation of Array
// Учитывая целочисленный массив nums длины n, необходимо создать массив ans длиной 2n,
// где ans[i] == nums[i] и ans[i + n] == nums[i] для 0 <= i < n (с индексом 0).
//В частности, ans это объединение двух nums массивов.
//Возвращаемый массив ans.

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;        // ввожу переменную равную длине массива nums
        int[] ans = new int[n * 2]; // создаю новый массив ans с длиной равной двойной длине массива nums

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // копирую (передаю) значение в элемент с индексом i из массива nums в массив ans
            ans[i + n] = nums[i];   // копирую значение в элемент с индексом i+n// {1,3,0,0,  1,3,0,0,}
            //0 1 2 3 4 5 6 7
            //1 2 3 1 1 2 3 1
        }
        return ans;                 // код более компактный - в цикле происходит одновременное копирование
        // двух элементов массива
    }

    public int[] getConcatenation1(int[] nums) {
        return IntStream.concat(IntStream.of(nums), IntStream.of(nums))
                .toArray();
    }


    public static void main(String[] args) {
        ConcatenationOfArray ca = new ConcatenationOfArray();
        int[] nums = {1, 3, 2, 1};
        int[] result = ca.getConcatenation1(nums);
        System.out.print(Arrays.toString(result));
    }
}

