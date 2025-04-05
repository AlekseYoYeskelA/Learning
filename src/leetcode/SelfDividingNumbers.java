package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SelfDividingNumbers {

    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        List<Integer> result = getSelfDividingNumbers(left, right);
        System.out.println("Первый метод" + result);
        System.out.println("Второй метод" + getSelfDividingNumbers2(left, right));
    }

    public static List<Integer> getSelfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        if (left > right) {                                  //добавлена проверка на валидность диапазона
            throw new IllegalArgumentException("left не может быть больше right");
        }

        for (int i = left; i <= right; i++) {
            // здесь провожу перебор чисел из заданного диапазона
            if (i / 10 == 0 || isSelfDividing(i)) { // вызываю метод, который для проверки, является ли число самоделящимся
                result.add(i);                    // если условия выполнятся, то результат добавляем в List
            }
        }
        return result;                          // после выполнения всех итераций возвращаем результат
    }

    // создаю метод, который будет отвечать на вопрос является ли число самоделящимся
    public static boolean isSelfDividing(int number) {
        int temp = number;                      // чтобы не потерять наше число, создаем временную переменную, которую будем разбирать по частям
        while (temp > 0) {
            int digit = temp % 10;              // 150
            //проверим два условия: 1) цифра не 0 и 2) число делится на цифру
            if (digit == 0 || number % digit != 0) {
                return false;
            }
            temp = temp / 10;                   // можно писать так temp /=10 - синтаксический сахар))
        }
        return true;
    }

    public static List<Integer> getSelfDividingNumbers2(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .filter(num -> num / 10 == 0 || isSelfDividing1(num))
                .boxed() //int -> Integer
                .toList();
    }

    //105
    public static boolean isSelfDividing1(int number) {
        String strNum = String.valueOf(number);

        //{1, 0, 5}
        Long count = strNum.chars()
                .map(codePoint -> Character.getNumericValue(codePoint)) // код -> "1" -> 1
                .peek(num -> System.out.println("Текущее число " + num))
                .filter(num -> num != 0)
                .filter(num -> number % num == 0)
                .count();

        return strNum.length() == count;
    }
}
