package Array;

public class AddOne {
    public static void main(String[] args) {
        int A[]={1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5 };
        int B[]={9,9,9,9,9};
        int C[]={ 2, 5, 6, 8, 6, 1, 2, 4, 5  };
        int Z[]=plusOne(C);
        for(int i=0;i<Z.length;i++){
            System.out.println(Z[i]);
        }
    }
    public static int[] plusOne(int[] a) {
//        int l =A.length;
//        double s=0;
//        int z=0;
//        for(int i=0;i<l;i++){
//            s=s+A[i]*Math.pow(10,l-i-1);
//            z=(int) s;
//        }
//        double num=s+1;
//        //int num=z+1;
//        System.out.println(Double.toString(num));
//        int j = Integer.toString(num).length();
//        int Arr[]= new int[j];
//        for(int i=j-1;i>=0;i--){
//            Arr[i]=(int)num%10;
//            num=num/10;
//        }
//
        int ind = -1;
        int n= a.length;
        // traverse in the array and find the first
        // non-zero number
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                ind = i;
                break;
            }
        }

        // if no non-zero number is there

        // Create an array to store
        // numbers apart from leading zeros
        int[] A = new int[n - ind];

        // store the numbers removing leading zeros
        for (int i = 0; i < n - ind; i++)
            A[i] = a[ind + i];
        int k=0;
        int l=A.length;
        for(int i=0;i<l;i++){
            if(A[i]==9)
                k=k+1;

        }
        if(k==l){
            int B[]=new int[l+1];
            for(int i=1;i<B.length;i++){
                B[i]=0;
            }
            B[0]=1;
            return B;
        }

        for(int i=l-1;i>=0;i--){
            if(A[i]<9){
                A[i]=A[i]+1;
                return A;
            }
            A[i]=0;

        }
        int e=1234;
        int f=Integer.valueOf(String.valueOf(e));
        System.out.println(f);

        return A;






    }
}
