package leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;

public class AcceptableParentheses {
    private static final Map<Character, Character> map = Map.of(
            '(', ')',
            '{', '}',
            '[', ']');

    public boolean isValid(String brackets) {
        //ArrayList<Character> arrayList = new ArrayList<>();//   } [ { } }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : brackets.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if (map.get(open) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String brackets) {
        ArrayList<Character> stack = new ArrayList<>();//   } [ { } }

        for (char c : brackets.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.removeLast();

                if (map.get(open) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

class AcceptableTest {
    public static void main(String[] args) {
        AcceptableParentheses p = new AcceptableParentheses();
        System.out.println(p.isValid("{()}}"));
    }
}