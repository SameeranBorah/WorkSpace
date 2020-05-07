package Miscellaneous;

public class BuySellStock3 {
    public static void main(String[] args) {
        int arr[]={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
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
        dp2[0]=0;
        int max_prev=Integer.MIN_VALUE;

        for(int i=1;i<prices.length;i++){
            max_prev=Math.max(max_prev,dp1[i-1]-prices[i-1]);
            dp2[i]=Math.max(dp2[i-1],prices[i]+max_prev);
            System.out.print(dp2[i]+" ");

        }
       return dp2[prices.length-1];
    }
}
