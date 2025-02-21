//Вам дан целочисленный массив banned и два целых числа n и maxSum.
// Вы выбираете некоторое количество целых чисел, следуя приведенным ниже правилам:
// - Выбранные числа должны находиться в диапазоне [1, n].
// - Каждое целое число может быть выбрано не более одного раза.
// - Выбранные целые числа не должны находиться в массиве banned.
// - Сумма выбранных целых чисел не должна превышать maxSum.
//Верните максимальное количество целых чисел, которые можно выбрать, следуя указанным правилам.
//
//Example 1:
//
//Input: banned = [1,6,5], n = 5, maxSum = 6
//Output: 2
//Explanation: You can choose the integers 2 and 4.
//2 and 4 are from the range [1, 5], both did not appear in banned, and their sum is 6, which did not exceed maxSum.
//Example 2:
//
//Input: banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1
//Output: 0
//Explanation: You cannot choose any integer while following the mentioned conditions.
//Example 3:
//
//Input: banned = [11], n = 7, maxSum = 50
//Output: 7
//Explanation: You can choose the integers 1, 2, 3, 4, 5, 6, and 7.
//They are from the range [1, 7], all did not appear in banned, and their sum is 28, which did not exceed maxSum.
//
// 1 <= banned.length <= 10^4
// 1 <= banned[i], n <= 10^4
// 1 <= maxSum <= 10^9

//Подсказка 1
//Сохраните в наборе запрещенные числа, которые меньше n.
//Подсказка 2
//Переберите числа от 1 до n и, если число не запрещено, используйте его.
//Подсказка 3
//Продолжайте добавлять числа, пока они не забанены, и их сумма меньше k.


package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;
        // создаем хэшсет и заполняем его запрещенными числами "num <= n" из входного массива
        Set<Integer> set = new HashSet<>();
        for (int num : banned) {
            if (num <= n) {
                set.add(num);
            }
        }
        // перебираем числа от 1 до n, если число не содержится в сете, прибавляем текущий эл-т к сумме, увеличиваем счетчик
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                sum += i;
                count++;
            }
            //Сравниваем записанную сумму с максимальной, если sum > maxSum, возвращаем сount-1 (значение счетчика из предыдущей итерации)
            if (sum > maxSum) {
                return count - 1;
            }
        }
        return count;
    }

    public int maxCount2(int[] banned, int n, int maxSum) {
        Set<Integer> set = Arrays.stream(banned)
                .boxed()
                .filter(num -> num <= n)
                .collect(Collectors.toSet());

        AtomicInteger ati = new AtomicInteger(0);

        IntStream.rangeClosed(1, n)  // 1 2 3 4 5,  maxSum = 6
                .filter(e -> !set.contains(e)) //2 3 4
                .reduce(maxSum, (acc, element) -> {
                    if (acc - element >= 0) {
                        ati.getAndIncrement();
                    }
                    return acc - element;
                });
        return ati.get();
    }
}


class Task2554Test {
    public static void main(String[] args) {
        int[] banned = {1,6,5};
        int n = 5;
        int maxSum = 6;
        Task2554 t1 = new Task2554();
        System.out.println(t1.maxCount(banned, n, maxSum)); //253
    }
}