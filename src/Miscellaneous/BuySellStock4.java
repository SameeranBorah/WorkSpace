package Miscellaneous;

public class BuySellStock4 {
    public static void main(String[] args) {
        int arr[]={1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(arr,4));
    }
    public static int maxProfit(int[] prices,int k) {
        int dp1[]=new int[prices.length];
        int dp2[]=new int[prices.length];
        int profit = 0,
                buy = prices[0];
        for (int i = 0; i < prices.length; i ++){
            if (prices[i] < buy)
                buy = prices[i];
            else
                profit = Math.max(profit, prices[i] - buy);
            dp1[i]=profit;
        }
        if(k==1)
            return dp1[prices.length-1];
        if(2*k>prices.length){
            profit=0;
            for(int i=0;i<prices.length-1;i++){
                if(prices[i+1]>prices[i])
                    profit+=prices[i+1]-prices[i];
            }
            return profit;
        }
        else {
            for (int j = 0; j < k - 1; j++) {
                int max_prev = Integer.MIN_VALUE;
                for (int i = 1; i < prices.length; i++) {
                    max_prev = Math.max(max_prev, dp1[i - 1] - prices[i - 1]);
                    dp2[i] = Math.max(dp2[i - 1], prices[i] + max_prev);
                }
                for (int i = 0; i < prices.length; i++) {
                    dp1[i] = dp2[i];
                }

            }
            return dp2[prices.length - 1];
        }
    }
}
