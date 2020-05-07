package Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JumpGAme {
    public static boolean canJump(int[] nums) {
      int last=nums.length-1;
      for(int i=nums.length-2;i>=0;i--){
          if(i+nums[i]>=last)
              last=i;
      }
      return last==0;
    }

    public static int canJump2(int[] nums) {
        int dp[]=new int[nums.length];
        int temp[]=new int [nums.length];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    if(dp[i]==0){
                        dp[i]=dp[j]+1;
                        temp[i]=j;}
                    if(dp[j]+1<dp[i]){
                        dp[i]=dp[j]+1;
                        temp[i]=j;
                    }

                }
            }
        }
        return dp[nums.length-1];
    }
    public static int canJump2_2(int[] nums){
        int rev[]=new int[nums.length];
        rev[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            int min=Integer.MAX_VALUE;
                for(int j=i+1;j<=Math.min(i+nums[i],nums.length-1);j++){
                    if(rev[j]<min){
                        min=rev[j];
                       }
                }
                if(min==Integer.MAX_VALUE)
                    rev[i]=min;
                else
                rev[i]=min+1;

        }
        System.out.println(Arrays.toString(rev));
        return rev[0];


    }
    public static int canJump2bfs(int[] nums){
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;

    }
    static ArrayList<Integer> a=new ArrayList<>();
    public static boolean canReach(int[] arr, int start) {
        if(a.contains(start))
            return false;
        a.add(start);
        if(arr[start]==0)
            return true;
        else{
            if(start+arr[start]<arr.length&&start-arr[start]>=0)
                return canReach(arr,start+arr[start])||canReach(arr,start-arr[start]);
            else if(start+arr[start]>=arr.length&&start-arr[start]>=0)
                return canReach(arr,start-arr[start]);
            else if(start+arr[start]<arr.length&&start-arr[start]<0)
                return canReach(arr,start+arr[start]);
            else return false;
        }
    }
    public static void main(String[] args) {
        int arr[]={3,0,2,1,2};

        //System.out.println(canJump2bfs( arr));
        System.out.println(canReach(arr,2));
    }
}
