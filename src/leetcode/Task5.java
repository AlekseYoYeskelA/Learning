//Если задана строка s, верните самую длинную палиндромную подстроку в s.
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//
// Example 2:
//
//Input: s = "cbbd"
//Output: "bb"

package leetcode;

import java.util.stream.IntStream;

public class Task5 {
    public static String longestPalindrome(String s) {
        for (int right = s.length(); right > 0; right--) {
            for (int left = 0; left <= s.length() - right; left++) {
                String sub = s.substring(left, left + right);
                if (isPalindrome1(sub)) {
                    return sub;
                }
            }
        }
        return "";
    }

    public static boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length() - 1;
        while (left < right) {
            //abba babad
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome1(String sub) {
        return IntStream.range(0, sub.length() / 2)
                .allMatch(i -> sub.charAt(i) == sub.charAt(sub.length() - i - 1));
    }

    public static void main(String[] args) {
        String s = "bdabad";
        //System.out.println(isPalindrome1(s));
        System.out.println(longestPalindrome(s));
    }
}
