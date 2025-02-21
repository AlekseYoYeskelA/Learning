package leetcode;

import static java.util.Arrays.stream;

public class Task12 {
    public static String intToRoman(int num) {
        //создаем 2 массива с арабскими и римскими цифрами в порядке убывания (это важно!)
        final int[] ARABICS = {1000,   900, 500, 400,  100,  90,  50,  40,   10,   9,    5,   4,    1};
        final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder(); //создаем StringBuilder, в который будем записывать римские цифры
        for (int i = 0; i < ARABICS.length && num > 0; i++) { // проходим по массиву с арабскими цифрами, учитываем, что входящее число > 0

            //Если входящее число num больше или равно i-му эл-ту массива ARABICS, то из числа num вычитаем этот i элемент,
            //а также в sb добавляем i-й символ из массива ROMANS
            while (num >= ARABICS[i]){
                num -= ARABICS[i]; // num = num-ARABICS[i];
                sb.append(ROMANS[i]);
            }
        }
        return sb.toString(); // возвращаем sb в виде строки
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
}
