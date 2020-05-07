package Miscellaneous;

import java.util.Scanner;
//first input is the size of array
//then are the array inputs//output largest pallindrome int(if pallindrome)
public class LargestPallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l=sc.nextInt();
        int arr[]=new int[l];
        for(int i=0;i<l;i++){
            int val=sc.nextInt();
            int temp=val;
            int r;
            int sum=0;
            int n=0;
            while(val>0){
                r=val%10;  //getting remainder
                sum=(sum*10)+r;
                val=val/10;
            }
            if(temp!=sum)
                arr[i]=0;
            else
                arr[i]=temp;
        }
        for(int i=0;i<l;i++){

        }
        int max = arr[0];
        for(int i = 0; i < l; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
