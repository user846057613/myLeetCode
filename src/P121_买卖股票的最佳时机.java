import java.util.Arrays;

public class P121_买卖股票的最佳时机 {

    /***
     * 暴力法，时间复杂度O(n2)
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    /***
     * 维护了最大利润变量与股票谷底价格变量，只需要一次遍历
     * 时间复杂度O(n)
     * @param prices
     * @return
     */
    public int maxProfitEasy(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

}
