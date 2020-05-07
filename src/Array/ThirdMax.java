package Array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ThirdMax {
    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(thirdMax(arr));
    }
    public static int thirdMax1(int[] nums) {
        int f=Integer.MIN_VALUE;
        int j=Integer.MIN_VALUE;
        int k=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(f<nums[i])
                f=nums[i];
        }
        for(int i=0;i<n;i++){
            if(j<nums[i]&&nums[i]!=f)
                j=nums[i];
        }
        for(int i=0;i<n;i++){
            if(k<nums[i]&&nums[i]!=f&&nums[i]!=j)
                k=nums[i];
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==f||nums[i]==j)
                count++;
        }
        if(count==n)
            return f;
        return k;
    }
    public static int thirdMax(int[] nums){
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i : nums){ts.add(i);}
        int back = ts.pollLast();
        int max=0;
        int num = 3;
        while(!ts.isEmpty() && num != 1){
            max = ts.pollLast(); num--;
            back = Math.max(max, back);
        }
        return num == 1? max : back;
    }
}
