package leetcode;

public class Task125 {
    public boolean isPalindrome(String s) {
        String str = onlyLettersAndDigits(s);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String onlyLettersAndDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    public boolean isPalindromeUsingStreams(String s) {
        StringBuilder builder = new StringBuilder();

        s.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> Character.toLowerCase((char) c))
                .forEach(builder::append);

        String newString = builder.toString();
        String reverseString = builder.reverse().toString();
        return newString.equals(reverseString);
    }
}


class Task125Test {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Task125 test = new Task125();
        System.out.println(test.onlyLettersAndDigits(s));
        System.out.println(test.isPalindrome(s));
    }
}