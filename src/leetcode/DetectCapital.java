package leetcode;

//Task 520
public class DetectCapital {
    public static void main(String[] args) {
        String word = "Google";
        System.out.println(detectCapital(word));
    }

    public static boolean detectCapital(String word) {
        long capital = word.chars()
                .filter(Character::isUpperCase)
                .count();

        if (capital == word.length() || capital == 0) {
            return true;
        }

        return capital == 1 && Character.isUpperCase(word.charAt(0));
    }
}
