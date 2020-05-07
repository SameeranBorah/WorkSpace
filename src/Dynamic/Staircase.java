package Dynamic;

public class Staircase {
    static int arr[]=new int [50];
    static int stepPerms(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        if(arr[n]!=0) return arr[n];
        arr[n]=(stepPerms(n-1)+stepPerms(n-2)+stepPerms(n-3))%1000000007;
        return arr[n]%1000000007;

    }

    public static void main(String[] args) {
        System.out.println(stepPerms(35));
    }
}
