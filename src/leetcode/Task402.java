//Даны строка num, представляющая неотрицательное целое число num, и целое число k,
//вернуть наименьшее возможное целое число после удаления k цифр из num.
//
//Constraints:
//1 <= k <= num.length <= 105
//num consists of only digits.
//num does not have any leading zeros except for the zero itself.
//
//
//Example 1:
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//
// Example 2:
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//
//Example 3:
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing which is 0.
//

package leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task402 {
    public String removeKdigits(String num, int k) {
        if (num.equals("0") || k == num.length()) {
            return "0";
        }
        //1 4 3 2 2 1 9
        StringBuilder result = new StringBuilder();

        // result.charAt(result.length()-1) - последняя цифра в стрингбилдере,
        // currentDigit - текущая цифра
        // к - количество цифр для удаления
        // пока заполняемый стрингбилдер НЕ пустой, k>0 и предыдущая цифра больше текущей
        for (char currentDigit : num.toCharArray()) {
            while (!result.isEmpty() && k > 0 && result.charAt(result.length() - 1) > currentDigit) {
                result.deleteCharAt(result.length() - 1); //удаляем цифру c конца стрингбилдера, тк она больше текущей
                k--;                                            // Уменьшаем на 1 кол-во удалений
            }
            result.append(currentDigit);                        // Добавляем текущую цифру в стрингбилдер в любом случае
        }
        // Удаляем оставшиеся цифры с конца стрингбилдера, если еще остались удаления
        while (k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }
        // Удаляем ведущие нули
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();                               // Возвращаем результат в виде строки
    }

    public String removeKdigits1(String num, int k) {
        StringBuilder result = new StringBuilder();
        AtomicInteger ati = new AtomicInteger(k);

        num.chars()
                .mapToObj(digit -> (char) digit)
                .map(digit -> result.chars()
                        .map(d -> {
                            if (ati.get() > 0 && result.charAt(result.length() - 1) > d) {
                                result.deleteCharAt(result.length() - 1);
                                ati.decrementAndGet();
                            }
                            return digit;
                        }))
                .forEach(result::append);


//        num.chars()
//                .mapToObj(digit -> (char) digit)
//                .map(digit -> {
//                    while (!result.isEmpty() && ati.get() > 0 && result.charAt(result.length() - 1) > digit) {
//                        result.deleteCharAt(result.length() - 1);
//                        ati.decrementAndGet();
//                    }
//                    return digit;
//                })
//                .forEach(result::append);

        while (ati.get() > 0) {
            result.deleteCharAt(result.length() - 1);
            ati.decrementAndGet();
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();

    }
}


class Test402 {
    public static void main(String[] args) {
        Task402 t = new Task402();
        String num = "10200"; //1219
        int k = 1;
        String result = t.removeKdigits1(num, k);
        System.out.println(result);
    }
}


//        result.chars().
//                filter(digit -> ati.get() > 0 && result.charAt(result.length() - 1) > digit)
//                .forEach(digit -> {
//                    ati.getAndDecrement();
//                    result.deleteCharAt(result.length() - 1);
//                });
//        List<Stream<Integer>> collect = num.chars()
//                .mapToObj(digit -> (char) digit)
//                .map(digit -> list.stream()
//                        .map(el -> list.removeIf(ch -> ati.get() > 0 && list.getLast() > ch))
//                        .map(el -> ati.getAndDecrement())
//                )
//                .collect(Collectors.toList());
//

//}


