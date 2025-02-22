package algorithms.arithmetic_parser;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String expression = "32 + 14 - 7 * (15 * 9 - 86 / 3) + (29 - 16) * 54";
        List<Lexeme> lexemes = Lexeme.lexAnalyze(expression);
        Lexeme.LexemeBuffer lexemeBuffer = new Lexeme.LexemeBuffer(lexemes);
        System.out.println(Lexeme.expr(lexemeBuffer));
    }
}
