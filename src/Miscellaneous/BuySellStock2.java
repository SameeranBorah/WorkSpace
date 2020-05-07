package Miscellaneous;

public class BuySellStock2 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(maxProfit(arr));
        //maxProfit(arr);
    }
    public static int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i])
                profit+=prices[i+1]-prices[i];
        }
        return profit;
    }
    public static int maxProfit_2(int[] prices) {
        int profit=0;
        int max=0;
        int buy=prices[0];
        int peak=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<buy){
                buy=prices[i];
                max=max+profit;
                profit=0;
            }
            else if(prices[i]-buy>profit){
                profit=prices[i]-buy;
                peak=prices[i];
            }
            else if(prices[i]<peak){
                buy=prices[i];
                max=max+profit;
                profit=0;
            }
        }
        max=max+profit;
        return max;
    }

}
