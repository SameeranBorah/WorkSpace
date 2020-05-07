package BinarySearch;

public class SearchRange {
    public static int firstElement(final int[] A, int B) {
        int n=A.length;
        int start=0;
        int end=n-1;
        int first_pos=n;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(A[mid]>=B){
                first_pos=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return first_pos;
    }

    public static int[] searchRange(final int[] A, int B) {

        int X=firstElement(A,B);
        int Y=firstElement(A,B+1)-1;
        int res[]={X,Y};
        if(X<=Y)
            return res;
        int res1[]={-1,-1};
        return res1;


    }

    public static void main(String[] args) {
        int A[] = {1};
        int B=1;
        int X[]=searchRange(A,B);
        System.out.println(X[0]);
        System.out.println(X[1]);
    }
}


