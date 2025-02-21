package leetcode;////Римские цифры представлены семью различными символами  : I, V, X, L, C, D, M
////
////        Значение символа
////        I 1
////        V 5
////        X 10
////        L 50
////        C 100
////        D 500
////        M 1000
////        Например,  2 пишется как II римская цифра, просто складывая две единицы. 12 пишется как  XII, что просто X + II.
////        Число 27 записывается как XXVII, то есть XX + V + II.
////
////        Римские цифры обычно пишутся от большей к меньшей слева направо.
////        Однако цифра «четыре» не является цифрой «четыре» IIII. Вместо этого число четыре записывается как IV.
////        Поскольку единица стоит перед пятеркой, мы вычитаем ее, получая четыре.
////        Тот же принцип применим и к числу девять, которое записывается как IX.
////        Есть шесть случаев, когда используется вычитание:
////
////        I можно поставить перед V(5) и X(10), чтобы получилось 4 и 9.
////        X можно поставить перед L(50) и C(100), чтобы получилось 40 и 90.
////        C можно поставить перед D(500) и M(1000), чтобы получить 400 и 900.
////        Дана римская цифра, преобразуйте ее в целое число.
//        Пример 1:
//
//        Ввод: s = «III»
//        Выход: 3
//        Объяснение: III = 3.
//        Пример 2:
//
//        Ввод: s = «LVIII»
//        Выход: 58
//        Объяснение: L = 50, V = 5, III = 3.
//        Пример 3:
//
//        Ввод: s = "MCMXCIV"
//        Вывод: 1994 г.
//        Объяснение: M = 1000, CM = 900, XC = 90 и IV = 4.


//
//
//        total = 0
//        i = 0
//        while i < s.length:
//        if at least 2 characters remaining and s.substing(i, i + 1) is in values:
//        total = total + (value of s.substring(i, i + 1))
//        i = i + 2
//        else:
//        total = total + (value of s[i])
//        i = i + 1
//        return total

import java.util.HashMap;
import java.util.Map;

public class Task13 {
    static Map<String, Integer> map = new HashMap<>();

    static {              //статический инит блок, заполняем мапу
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }


    public static int romanToInt(String s) {
        int result = 0;
        int index = 0;
        while (index < s.length()) {
            if (index < s.length() - 1) {
                String twoSymb = s.substring(index, index + 2); //вычленяем два символа
                if (map.containsKey(twoSymb)) {                 //проверяем, есть ли в мапе данный ключ из 2х символов
                    result += map.get(twoSymb);                 //если true, возвращаем значение по ключу
                    index += 2;                                 //переходим на 2 индекса вперед
                    continue;
                }
            }
            String oneSymb = s.substring(index, index + 1);    //если false, переходим к односимвольным ключам
            result += map.get(oneSymb);                        //возвращаем значение по ключу
            index += 1;                                       //переходим на 1 индекс вперед
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
