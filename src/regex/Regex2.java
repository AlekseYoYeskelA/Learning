package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABC");// шаблон для поиска

//        String s1 = "ABCDOPAB3OP";
//        Pattern pattern1 = Pattern.compile("AB[C-F1-9]OP");/ [a-z] - один символ из диапазона от a до z

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc[^e-g4-7]");// [^ ] - отрицание

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)");// | - или

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc.");// . - любой символ

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("^abc$");// ^ - в начале строки, $ - в конце строки

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\d");// \d - одна любая цифра, \D - один символ, кроме цифр
//        System.out.println("abcd \\ efg"); // \ - перекрывает системный символ и не дает его выводить

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w");// \w - буква, цифра или "_" [A_Za-z0-9_]

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w+"); // + - 1 или больше повторений,

//        String s1 = "abcd!?abce++ =-abc+/*-5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\W+");// \W - НЕ буква, НЕ цифра, НЕ "_"

//        String s1 = "poka abc Alex dom kino";
//        Pattern pattern1 = Pattern.compile("\\w{4}"); // {4} - количество символов подряд

//        String s1 = "poka    abc  Alex  dom   kino    asdhoaassd";
//        Pattern pattern1 = Pattern.compile("\\w\\s+\\w"); // \s - пробел

//        String s1 = "abcd abce3 abcfa78abcg6abch!?!**!?!?!!!!!!/*";
//        Pattern pattern1 = Pattern.compile("\\D{2,6}"); // {2,6} - количество символов подряд от 2 до 6

//        String s1 = "ABCABABDA";
//        Pattern pattern1 = Pattern.compile("(AB){2,3}"); // (AB) - поиск выражения

//        String s1 = "DABCDABABDABABABABD";
//        Pattern pattern1 = Pattern.compile("D(AB){2,}"); // (AB) - поиск выражения

//        String s1 = "DABCDABABDABABABABD";
//        Pattern pattern1 = Pattern.compile("D(AB)?"); // ? - 1 или 0 повторений, * - 0 или больше повторений

//        String s1 = "abcd abce abcfabcgabch";
//        Pattern pattern1 = Pattern.compile("\\Aabcd"); // \A - начало строки \Z - конец строки

        String s1 = "abcd abcd4 afc4ced7";
        Pattern pattern1 = Pattern.compile("[abcd][efgd3-8]");




        Matcher matcher = pattern1.matcher(s1);
        while(matcher.find()){
            System.out.println("Position: " + matcher.start() + "  " + matcher.group());
        }
    }
}
