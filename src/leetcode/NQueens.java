package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Task 51
/*Алгоритм
Мы создадим рекурсивную функцию backtrack, которая принимает несколько аргументов для поддержания состояния доски.
Первый параметр — это строка, на которую мы собираемся поместить ферзя, а затем у нас будет 3 множества, которые отслеживают,
на каких столбцах, диагоналях и антидиагоналях уже размещены ферзи. Кроме того, мы сохраним фактическую доску,
чтобы, когда мы найдем допустимое решение, мы могли включить его в наш ответ. Функция будет работать следующим образом:

1.Если текущая строка, которую мы рассматриваем, равна n, то у нас есть решение.
Добавьте текущее состояние доски в список решений и верните.
Мы воспользуемся небольшой вспомогательной функцией, чтобы перевести нашу доску в правильный формат вывода.

2.Пройдемся по столбцам текущей строки.
В каждом столбце мы попытаемся поместить ферзя в клетку (row, col) — помните, что мы рассматриваем текущую строку через аргументы функции.

-Вычислите диагональ и антидиагональ, к которым принадлежит квадрат.
Если ферзь не был помещен в столбец, диагональ или антидиагональ, то мы можем поместить ферзя в этот столбец, в текущую строку.
-Если мы не можем разместить ферзя, пропускаем этот столбец (переходим к следующему столбцу).

3.Если нам удалось разместить ферзя, то добавляем ферзя на доску и обновляем наши 3 набора (cols, diagonals, и antiDiagonals),
а затем снова вызываем функцию, но уже с row + 1.

4.Вызов функции, сделанный на шаге 3, исследует все допустимые состояния доски с ферзем, которого мы разместили на шаге 2.
Поскольку мы закончили исследование этого пути, вернитесь назад, удалив ферзя с поля — это включает удаление значений,
которые мы добавили в наши наборы поверх удаления "Q"с доски.
*/

public class NQueens {
    private int size;
    private List<List<String>> solutions = new ArrayList<>();

    //заполнение доски пустыми значениями ("." - пустая клетка)
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    //Использование вспомогательного метода для преобразования 2d-массива в список строк (char[][] -> List<String>)
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            String currentRow = new String(state[row]);
            board.add(currentRow);
        }
        return board;
    }

    //Параметры:
    // row - текущая строка, на которую планируется разместить ферзя
    // diagonls, antiDiagonals, cols - множества, которые отслеживают, на каких диагоналях, анти-диагоналях и столбцах уже размещены ферзи
    // state - фактическое(текущее) состояние доски
    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }

        //итерация по столбцам, нахождение текущих диагоналей
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
               continue;
            }

            //добавление ферзя на доску
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            //Удаление ферзя с доски, тк все возможные пути уже были исследованы
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }
}

class NQueensTest {
    public static void main(String[] args) {
        NQueens queens = new NQueens();
        System.out.println(queens.solveNQueens(4));
    }
}
