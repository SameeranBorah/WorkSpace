package Array;

public class PreetyPrint {
    public static void main(String[] args) {
        int A=4;
        for(int i=A-1;i>=-A+1;i--){
            for(int j=A-1;j>=-A+1;j--){
                System.out.print(Math.max(Math.abs(i),Math.abs(j))+1+" ");
            }
            System.out.println();
        }
    }
}
