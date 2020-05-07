package Array;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> x
                = new ArrayList<ArrayList<Integer> >();
        x.add(new ArrayList<Integer>());
        //x.add(new ArrayList<Integer>());
        x.get(0).add(2);
        x.get(1).add(2);

        System.out.println(x);
        Scanner sc = new Scanner(System.in);
     //   int x=sc.nextInt();

    }
}
