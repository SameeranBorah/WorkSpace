package Miscellaneous;

public class BuySellStock {
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int max[]=new int[prices.length];
        int min[]=new int[prices.length];
        int m=prices[0];
        int n=prices[prices.length-1];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<m){
                m=prices[i];
                max[i]=m;
            }
            else
                max[i]=m;

        }
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>n){
                n=prices[i];
                min[i]=n;
            }
            else
                min[i]=n;

        }
        for(int i=0;i<prices.length;i++){
            System.out.print(max[i]+" ");
        }
        System.out.println();
        for(int i=0;i<prices.length;i++){
            System.out.print(min[i]+" ");
        }
        int diff=0;
        for(int i=0;i<prices.length;i++){
            if(min[i]-max[i]>diff){
                diff=min[i]-max[i];
            }
        }
        return diff;
    }
}
