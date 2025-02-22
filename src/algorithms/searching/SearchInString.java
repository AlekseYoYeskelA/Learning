package algorithms.searching;

import java.util.ArrayList;
import java.util.Arrays;


public class SearchInString {
    public static void main(String[] args) {
        String text = "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";
        System.out.println(naiveSearch(text, sample));
        System.out.println(Arrays.toString(prefixFunction(sample)));
        System.out.println(KMPSearch(text, sample));
    }

    static ArrayList<Integer> naiveSearch(String text, String sample) {
        ArrayList<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int currenPos = 0;
            while (currenPos < sample.length() && currenPos + i < text.length() && sample.charAt(currenPos) == text.charAt(currenPos + i)) {
                currenPos++;
            }
            if (currenPos == sample.length()) {
                foundPositions.add(i);
            }
        }
        return foundPositions;
    }

    static int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int currentIdx = 0;
            while ((i + currentIdx) < sample.length() && sample.charAt(currentIdx) == sample.charAt(i + currentIdx)) {
                values[i + currentIdx] = Math.max(values[i + currentIdx], currentIdx + 1);
                currentIdx++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int textIdx = 0;
        int sampleIdx = 0;

        while (textIdx < text.length()) {
            if (sample.charAt(sampleIdx) == text.charAt(textIdx)) {
                sampleIdx++;
                textIdx++;
            }

            if (sampleIdx == sample.length()) {
                found.add(textIdx - sampleIdx);
                sampleIdx = prefixFunc[sampleIdx - 1];
            } else if (textIdx < text.length() && sample.charAt(sampleIdx) != text.charAt(textIdx)) {
                if (sampleIdx != 0) {
                    sampleIdx = prefixFunc[sampleIdx - 1];
                } else {
                    textIdx = textIdx + 1;
                }
            }
        }
        return found;
    }
}
