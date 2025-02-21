package leetcode;

import java.util.stream.IntStream;

public class Task68Stream {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];


        IntStream.range(1, rows).forEach(i -> dp[i][0] = dp[i - 1][0] + grid[i][0]); // 1 2 3     1 3 6
        // 4 5 6     5 8 12


        IntStream.range(1, cols).forEach(j -> dp[0][j] = dp[0][j - 1] + grid[0][j]);


        IntStream.range(1, rows).forEach(i ->
                IntStream.range(1, cols).forEach(j ->
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                )
        );


        return dp[rows - 1][cols - 1];
    }
}
class Task68StreamTest {

    public static void main(String[] args) {
        Task68Stream solution = new Task68Stream();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minSum = solution.minPathSum(grid);
        System.out.println("Минимальная сумма: " + minSum);
    }
}
