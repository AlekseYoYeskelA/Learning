package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(target, combination, 0, candidates, results);
        return results;
    }

    protected static void backtrack(int remain, LinkedList<Integer> combination, int start, int[] candidates, List<List<Integer>> results) {
        if (remain == 0) {
            //создаем копию текущей комбинации
            results.add(new ArrayList<Integer>(combination));
            return;
        } else if (remain < 0) {
            //заканчиваем исследование, если выходим за пределы исходного значения
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //добавляем число в комбинацию
            combination.add(candidates[i]);  //candidates = {2, 3, 5}
            backtrack(remain - candidates[i], combination, i, candidates, results);
            //возвращаемся назад, удаляем последнее число из комбинации
            combination.removeLast();
        }
    }
}

class Test39 {
    public static void main(String[] args) {
        Task39 t = new Task39();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(t.combinationSum(candidates, target));
    }
}
