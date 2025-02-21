package leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurrence = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), s::lastIndexOf, (oldV, newV) -> newV));

        AtomicInteger index = new AtomicInteger(-1);

        s.chars()
                .peek(currentChar -> index.getAndIncrement())
                .mapToObj(currentChar -> (char) currentChar)
                .filter(currentChar -> !seen.contains(currentChar))
                .forEach(currentChar -> {
                    while (!stack.isEmpty() && currentChar < stack.peek() && lastOccurrence.get(stack.peek()) > index.get()) {
                        seen.remove(stack.pop());
                    }
                    seen.add(currentChar);
                    stack.push(currentChar);
                });

        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public String removeDuplicateLetters1(String s) {
        //Deque<Character> stack = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!seen.contains(currentChar)) {
                while (!stack.isEmpty() && currentChar < stack.peek() && lastOccurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(currentChar);
                stack.push(currentChar);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }

        return sb.toString();
    }
}

class Test316 {
    public static void main(String[] args) {
        String s = "ecbacba";
        Task316 t = new Task316();
        System.out.println("Стрим: " + t.removeDuplicateLetters(s));
        System.out.println("Цикл: " + t.removeDuplicateLetters1(s));
    }
}

