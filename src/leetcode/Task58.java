package leetcode;

import java.util.Arrays;

public class Task58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}

class Test58 {
    public static void main(String[] args) {
        Task58 t = new Task58();
        String s = "   fly me   to   the moon  ";
        System.out.println(t.lengthOfLastWord(s));
    }
}