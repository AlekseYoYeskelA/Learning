package leetcode;

import java.util.Arrays;

public class Banknotes {
    public static void main(String[] args) {
        int[] banknotes = {10, 50, 100, 200, 500, 1000, 2000, 5000};
        System.out.println(minBanknotes(banknotes, 880));
        System.out.println(minBanknotes1(banknotes, 880));
    }

    public static int minBanknotes(int[] banknotes, int amount) {
        int count = 0;
        Arrays.sort(banknotes);

        for (int i = banknotes.length - 1; i >= 0; i--) {
            int currBank = banknotes[i];

            if (amount >= currBank) {
                count += amount / currBank;
                amount %= currBank; //amount = amount % currBank
            }
        }
        return amount == 0 ? count : -1;
    }

    //с помощью динамического массива
    public static int minBanknotes1(int[] banknotes, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        Arrays.sort(banknotes);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int banknote : banknotes) {
                if (banknote > i) {
                    break;
                }
                if (dp[i - banknote] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - banknote] + 1);

                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

