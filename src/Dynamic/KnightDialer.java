package Dynamic;

public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(2));
    }
    public static int knightDialer(int N) {
        if(N==1) return 10;
        if(N==2) return 20;
        int mod = 1000000007;
        int [][]dp=new int[4][3];
        dp[0][0]=2;
        dp[0][1]=2;
        dp[0][2]=2;
        dp[1][0]=3;
        dp[1][1]=0;
        dp[1][2]=3;
        dp[2][0]=2;
        dp[2][1]=2;
        dp[2][2]=2;
        dp[3][1]=2;
        int dp1[][]=new int[4][3];
        for(int k=3;k<=N;k++){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(i==3&&j==2){
                        continue;
                    }
                    if(i==3&&j==0){
                        continue;
                    }
                    int temp=0;
                    if(i-2>=0&&j-1>=0)
                        temp=temp+dp[i-2][j-1]%mod;
                    temp=temp%mod;
                    if(i-2>=0&&j+1<3)
                        temp=temp+dp[i-2][j+1]%mod;
                    temp=temp%mod;

                    if(i+2<4&&j-1>=0)
                        temp=temp+dp[i+2][j-1]%mod;
                    temp=temp%mod;

                    if(i+2<4&&j+1<3)
                        temp=temp+dp[i+2][j+1]%mod;
                    temp=temp%mod;

                    if(i-1>=0&&j-2>=0)
                        temp=temp+dp[i-1][j-2]%mod;
                    temp=temp%mod;
                    if(i-1>=0&&j+2<3)
                        temp=temp+dp[i-1][j+2]%mod;
                    temp=temp%mod;
                    if(i+1<4&&j-2>=0)
                        temp=temp+dp[i+1][j-2]%mod;
                    temp=temp%mod;
                    if(i+1<4&&j+2<3)
                        temp=temp+dp[i+1][j+2]%mod;
                    dp1[i][j]=temp%mod;



                }
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    dp[i][j]=dp1[i][j];
                    //System.out.print(dp[i][j]+" ");
                }
                //System.out.println();
            }
        }
        int sum=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                sum=(sum+dp1[i][j])% 1000000007;
                System.out.print(dp1[i][j]+" ");
            }
            System.out.println();
        }

        return sum;

    }
}
