package leetcode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskString {
    public static boolean isTransform(String source, String target) {

        if (source.length() != target.length()) {
            return false;
        }


        StringBuilder sourceSb = new StringBuilder(source);
        StringBuilder targetSb = new StringBuilder(target);

        for (int i = 0; i < source.length(); i++) {
            if (sourceSb.compareTo(targetSb) == 0) {
                return true;
            }

            sourceSb.append(source.charAt(i))
                    .deleteCharAt(0);

            System.out.println(sourceSb);
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcde";
        String target = "eabcd";
        System.out.println(isTransform(str, target));
    }
}

