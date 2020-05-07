package Array;

public class HappyNumber {
    public static void main(String[] args) {

        System.out.println(isHappy(4));

    }
    public static boolean isHappy(int n) {
        if(n==1||n==7)
            return true;
        int k=0;
        if(n/10<1)
            k=k+n*n;
        else{
            while(n>=1){
                k=k+(n%10)*(n%10);
                n=n/10;
            }
        }
        isHappy(k);

         return false;
    }
}
