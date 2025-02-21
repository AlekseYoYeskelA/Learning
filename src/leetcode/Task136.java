package leetcode;//Учитывая непустой  массив целых чисел nums, каждый элемент появляется дважды, кроме одного. Найдите этого единственного.
//
//Вы должны реализовать решение с линейной сложностью времени выполнения и использовать только постоянное дополнительное пространство.
//
//Пример 1:
//
//Ввод: nums = [2,2,1]
//Вывод: 1
//Пример 2:
//
//Ввод: nums = [4,1,2,1,2]
//Вывод: 4
//
// Пример 3:
//Ввод: nums = [1]
//Вывод: 1


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task136 {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // создаем мапу, где ключ - элемент массива, а значение - количество повторений
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); //заполняем мапу, с помощью метода getOrDefault проверяем повторения
        }
        for (int num : nums) {
            if (map.get(num) == 1) { //если элемент num повторяется всего 1 раз (значение по ключу == 1), то возвращаем его.
                return num;
            }
        }
        return 0;  //возвращаем 0, если все эл-ты массива имеют повторы;
    }

    public static void singleNumber1(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .forEach(key -> System.out.println(key));
    }


    public static void main(String[] args) {
        singleNumber1(new int[]{4, 1, 2, 1, 2});
    }
}
