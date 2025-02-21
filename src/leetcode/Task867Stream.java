package leetcode;


import java.util.Arrays;
import java.util.stream.IntStream;


public class Task867Stream {

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return IntStream.range(0, cols) // Создаем поток целых чисел от 0 до количества столбцов
                .mapToObj(col -> IntStream.range(0, rows) // Для каждого столбца создаем поток строк
                        .map(row -> matrix[row][col]) // Преобразуем в поток элементов матрицы 1 2 3
                        .toArray()) // Собираем элементы потока в массив                       4 5 6
                .toArray(int[][]::new); // Собираем массивы в двумерный массив
    }

    public static void main(String[] args) {
        Task867Stream matrixTransposer = new Task867Stream();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        int[][] transposedMatrix = matrixTransposer.transpose(matrix);


//        for (int i = 0; i < transposedMatrix.length; i++) {
//            for (int j = 0; j < transposedMatrix[0].length; j++) {
//                System.out.print(transposedMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        Arrays.stream(transposedMatrix)
                .forEach(subArray -> {
                    Arrays.stream(subArray)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });

    }
}
