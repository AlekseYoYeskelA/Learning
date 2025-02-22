package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static List<String> generateParenthesisBacktrack(int n) {
        List<String> resultList = new ArrayList<>();
        bactracking(resultList, new StringBuilder(), 0, 0, n);

        return resultList;
    }

    private static void bactracking(List<String> resultList, StringBuilder currentString, int leftCount, int rightCount, int n) {
       //проверка на длину строки, если true, то добавляем строку в результирующий список
        if (currentString.length() == 2 * n) {
            resultList.add(currentString.toString());
            return;
        }

        //если левый счетчик меньше n, в текущую строку добавляем открывающую скобку
        //и рекурсивно вызываем метод backtracking со значением левого счетчика + 1
        if (leftCount < n) {
            currentString.append("(");
            bactracking(resultList, currentString, leftCount + 1, rightCount, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }

        //если левый счетчик больше правого, в текущую строку добавляем закрывающую скобку
        //и рекурсивно вызываем метод backtracking со значением правого счетчика + 1
        if (leftCount > rightCount) {
            currentString.append(")");
            bactracking(resultList, currentString, leftCount, rightCount + 1, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }


    public static List<String> generateParenthesisDynamic(int n) {
        if (n == 0) {
            return new ArrayList<>(List.of(""));
        }

        List<String> resultList = new ArrayList<>();
        for (int leftCount = 0; leftCount < n; ++leftCount) {
            for (String leftString : generateParenthesisDynamic(leftCount)) {
                for (String rightString : generateParenthesisDynamic(n - 1 - leftCount)) {
                    resultList.add("(" + leftString + ")" + rightString);
                }
            }
        }
        return resultList;
    }
}

class Test22 {
    public static void main(String[] args) {
        System.out.println(Task22.generateParenthesisBacktrack(3));
        //System.out.println(Task22.generateParenthesisDynamic(3));
    }
}
