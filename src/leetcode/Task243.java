package leetcode;//Учитывая массив строк wordsDict и две разные строки, которые уже существуют в массиве word1 и word2,
//верните кратчайшее расстояние между этими двумя словами в списке .
//
//Example 1:
//
//Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
//Output: 3
//Example 2:
//
//Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
//Output: 1


public class Task243 {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = wordsDict.length;
        for (int i = 0; i < min; i++) {
            if (wordsDict[i].equals(word1)) {
                for (int j = 0; j < min; j++){
                    if(wordsDict[j].equals(word2)){
                        min = Math.min(min, Math.abs(i-j));
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println(shortestDistance(wordDict, word1, word2));
    }
}
