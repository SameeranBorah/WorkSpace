package Array;

public class MoveZeros {
    public static void main(String[] args) {
        int arr[]={1,2,0,4,0,0,6,3,0,4,7,0,0,4,2,7,6,5};
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){

                arr[count]=arr[i];
                count++;
            }
        }
        while(count<arr.length){
            arr[count]=0;
            count++;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
