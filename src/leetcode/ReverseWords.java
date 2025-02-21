package leetcode;

import java.util.Arrays;

public class ReverseWords {
    public static String reverseWords(String myString) {
        //StringBuilder result = new StringBuilder();

        return Arrays.stream(myString.split(" "))
                .map(word -> new StringBuilder(word)
                        .reverse()
                        .append(" "))
                .reduce(new StringBuilder(), StringBuilder::append)
                .toString();

        //.forEach(result::append);
        //return result.toString().trim();
    }

    public static void main(String[] args) {
        String myString = "abc def ghi jkl";
        String myString2 = "Let's take LeetCode contest";
        System.out.println(reverseWords(myString2));
    }
}

