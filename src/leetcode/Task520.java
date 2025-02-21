package leetcode;

public class Task520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean detectCapitalUse1(String word) {
        return word.matches("[A−Z]∗∣.[a−z]∗");
    }
}

class Test520 {
    public static void main(String[] args) {
        Task520 t = new Task520();
        String word = "KAPIBARA";
        System.out.println(t.detectCapitalUse(word));
    }
}
