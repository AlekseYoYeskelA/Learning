//Строка хороша, если в ней нет повторяющихся символов.
//Если дана строка s, верните количество хороших подстрок длиной 3 символа из s.
//Обратите внимание, что если одна и та же подстрока встречается несколько раз, необходимо подсчитать каждое ее появление.
//Подстрока - это непрерывная последовательность символов в строке.

package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


public class Task1876 {
    //метод скользящего окна (sliding window)
    public int countGoodSubstrings(String s) {
        int result = 0;                               //счетчик хороших подстрок/результат
        int left = 0;                                 //левый указатель
        int right = 0;                                //правый указатель
        Set<Character> set = new HashSet<>();         //создаем сет, в который будем записывать значения (хранит уникальные значения)
        //a a b b a c a b c   s.length = 9
        // set:  b c
        // right 9
        // left  7
        // result 3

        while (right < s.length()) {                  //итерируем, пока не дойдем до конца исходной строки
            if (!set.contains(s.charAt(right))) {     //проверяем, содержит ли сет текущий символ
                set.add(s.charAt(right));             //записываем, если символа еще нет в сете (true)
                if (set.size() == 3) {                //сравниваем размер сета с условием (по условию задачи длина подстроки = 3)
                    result++;                         //если true (значит нашлась подстрока с разными символами), увеличиваем результат на 1
                    set.remove(s.charAt(left));       //удаляем из сета самый левый символ подстроки
                    left++;                           //передвигаем левый указатель на следующий символ
                }
                right++;                              //передвигаем правый указатель на следующий символ
            } else {                                  //если сет уже содержит символ
                set.remove(s.charAt(left));           //удаляем из сета самый левый символ подстроки
                left++;                               //передвигаем левый указатель на следующий символ
            }
        }
        return result;                                //возвращаем результат
    }


    public int countGoodSubstrings1(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2)) {
                result++;
            }
        }
        return result;
    }

    public int countGoodSubstrings2(String s) {
        //AtomicInteger result = new AtomicInteger(0);

        return (int) IntStream.range(0, s.length() - 2)
                .filter(ch -> s.charAt(ch) != s.charAt(ch + 1)
                        && s.charAt(ch) != s.charAt(ch + 2)
                        && s.charAt(ch + 1) != s.charAt(ch + 2))
                .count();
        //.forEach(num -> result.getAndIncrement());

    }
}


class Test1876 {
    public static void main(String[] args) {
        Task1876 t = new Task1876();
        String s = "aabbacabc";
        System.out.println(t.countGoodSubstrings(s));
    }
}