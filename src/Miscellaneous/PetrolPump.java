package Miscellaneous;

import java.io.IOException;
import java.util.Scanner;

public class PetrolPump {
    static int truckTour(int[][] petrolpumps) {
        int n= petrolpumps.length;
        int i=0;
        long leftOver=0;
        while(n>0){

            if(petrolpumps[i][0]+leftOver>=petrolpumps[i][1]){
                leftOver=petrolpumps[i][0]+leftOver-petrolpumps[i][1];
                n--;
            }
            else{
                n=petrolpumps.length;
                leftOver=0;

            }
            i=(i+1)%petrolpumps.length;
        }
        return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
           petrolpumps[petrolpumpsRowItr][0]=scanner.nextInt();
            petrolpumps[petrolpumpsRowItr][1]=scanner.nextInt();
        }

        int result = truckTour(petrolpumps);

        System.out.println(result);

    }
}
