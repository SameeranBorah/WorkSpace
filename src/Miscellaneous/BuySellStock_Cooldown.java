package Miscellaneous;

public class BuySellStock_Cooldown {
    public static void main(String[] args) {
        int arr[]={1,4,2};
        System.out.println(maxProfit(arr));
        //maxProfit(arr);
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int temp = prices[0]; int flag = 0;

        for(int j = 1; j < prices.length; ++j){
            dp[j] = Math.max(dp[j-1], prices[j] - temp);
            if(j >= 2){
                temp = Math.min(temp, prices[j] - dp[j - 2]);
            }else temp = Math.min(temp, prices[j] - dp[j - 1]);
        }
        return dp[prices.length - 1];
    }
}
