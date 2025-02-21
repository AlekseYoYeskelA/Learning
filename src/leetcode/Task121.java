//Вам дан массив, prices, где prices[i] — цена определенной акции в день ith
//Вы хотите максимизировать свою прибыль, выбрав один день для покупки одних акций и другой день в будущем для продажи этих акций.
//Верните максимальную прибыль, которую вы можете получить от этой транзакции. Если вы не можете получить никакой прибыли, верните 0.
//
//Пример 1:
//Вход: цены = [7,1,5,3,6,4]
//Выход: 5
//Объяснение: Купить на 2-й день (цена = 1) и продать на 5-й день (цена = 6), прибыль = 6-1 = 5.
//Обратите внимание, что покупка во второй день и продажа в первый день не допускаются, поскольку перед продажей необходимо сначала купить.

//Пример 2:
//Вход: цены = [7,6,4,3,1]
//Выход: 0
//Пояснение: В этом случае транзакции не совершаются, а максимальная прибыль = 0.

package leetcode;

import java.util.Arrays;

public class Task121 {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice > profit) {
                profit = prices[i] - buyPrice;
            }
        }
        return profit;
    }
}


class Test121 {
    public static void main(String[] args) {
        Task121 t = new Task121();
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9}; //9
        int[] prices1 = {7, 1, 5, 3, 6, 4}; //5
        System.out.println(t.maxProfit(prices));

//        int[][] arr = {{1,2,3}, {4,5,6}};
//        Arrays.stream(arr).forEach(ar-> System.out.println(Arrays.toString(ar)));
    }
}
