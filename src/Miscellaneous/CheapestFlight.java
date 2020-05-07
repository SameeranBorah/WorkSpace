package Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CheapestFlight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k+2][n];
        for(int i=0; i<=k+1; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //fly from src to scr cost 0
        for(int i=0; i<=k+1; i++){
            dp[i][src] = 0;
        }

        for(int i=1; i<=k+1; i++){
            for(int[] f: flights){
                if(dp[i-1][f[0]]!=Integer.MAX_VALUE){
                    dp[i][f[1]] = Math.min(dp[i][f[1]],dp[i-1][f[0]]+f[2]);
                }
            }
        }
        return dp[k+1][dst] == Integer.MAX_VALUE ? -1 : dp[k+1][dst];

//        int[][][] DP=new int[n][n][2];
//        for(int i=0;i<flights.length;i++){
//            DP[flights[i][0]][flights[i][1]][0]=flights[i][2];
//            DP[flights[i][0]][flights[i][1]][1]=K;
//
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i==j){
//
//                    DP[i][j][1] = K;
//                }
//                else if(DP[i][j][0]<=0) {
//                    DP[i][j][0] = 10000;
//                    DP[i][j][1] = K;
//                }
//
//            }
//        }
//        int[][] DP=new int[n][n];
//        for(int i=0;i<flights.length;i++){
//            DP[flights[i][0]][flights[i][1]]=flights[i][2];
//
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//
//                if(DP[i][j]<=0) {
//                    DP[i][j] = 10000;
//                }
//
//            }
//        }
//        ArrayList<Integer>A=new ArrayList<>();
//        for(int i=1;i<=K+1;i++){}
//            A.add(shortestPath(n,DP, src, dst, i));
//        if(x>=10000)
//            return -1;
//        else
//           if(Collections.min(A).equals(1000))
//               return -1;
//           else return Collections.min(A);
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(DP[i][j][0]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for(int k=n-1;k>=0;k--){
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    if(DP[i][k][1]>0&&DP[k][j][1]>0){
//                        if(DP[i][k][0]+DP[k][j][0]<=DP[i][j][0]){
//                            DP[i][k][1]--;
//                            DP[k][j][1]--;
//                            DP[i][j][0]=DP[i][k][0]+DP[k][j][0];
//                        }
//
//                    }
//                }
//            }
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(DP[i][j][0]+" ");
//            }
//            System.out.println();
//        }
//        if(DP[src][dst][0]>=10000)
//            return -1;
//        else return DP[src][dst][0];
//    }
//    static final int INF = 10000;
//    static int shortestPath(int V,int graph[][], int u, int v, int k)
//    {
//        // Base cases
//        if (k == 0 && u == v)             return 0;
//        if (k == 1 && graph[u][v] != INF) return graph[u][v];
//        if (k <= 0)                       return INF;
//
//        // Initialize result
//        int res = INF;
//
//        // Go to all adjacents of u and recur
//        for (int i = 0; i < V; i++)
//        {
//            if (graph[u][i] != INF && u != i && v != i)
//            {
//                int rec_res = shortestPath(V,graph, i, v, k-1);
//                if (rec_res != INF)
//                    res = Math.min(res, graph[u][i] + rec_res);
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
       //int flights[][]={{0,1,100},{1,2,100},{0,2,500}};
       //int flights[][]= {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
      // int flights[][]={{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int flights[][]={{0,1,2},{1,2,1},{2,0,10}};
        System.out.println(findCheapestPrice(3,flights,1,2,1));
    }
}
