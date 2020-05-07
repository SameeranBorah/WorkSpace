package Dynamic;

public class ProfixMax {
    static int solve(int[] p) {
        // Write your code here
        int dp[]=new int[p.length];
        dp[0]=p[0];
        int max=0;
        for(int i=1;i<p.length;i++){
            int j=i-1;
            while(j>=0) {
                if (p[i] % p[j] == 0) {
                    dp[i]=p[i]+dp[j];
                    break;
                }
                else{
                    dp[i]=p[i];
                }
                j--;
            }
            if(dp[i]>max)
                max=dp[i];
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
        return max;

    }

    public static void main(String[] args) {
        int A[]={1,2,3,4,9,8};
        System.out.println(solve(A));
    }
}
