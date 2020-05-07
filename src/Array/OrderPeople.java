package Array;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class OrderPeople {
    public static ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<A.size();i++){
            map.put(A.get(i),B.get(i));
        }
        ArrayList<Integer> res=new ArrayList<>(A.size());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(entry.getValue(),entry.getKey());
        }
        return res;
    }
    public static int[][] reconstructQueue(int[][] people) {

        /* basically sorting the people on the basis of height and if the height is same then on the basis of the number of people in front of them */

        List<int []> result = new ArrayList<>();
        Arrays.sort(people, (n1, n2)->(n1[0] == n2[0] ? n1[1]-n2[1] : n2[0]- n1[0]));

        /* since we have the people sorted height wise the shorter people will not affect the people with greater height
       example after sort
        (7,0), (7,1), (6,1), (5,0), (5,2), (4,4)

	   inserting now:
        (7,0) (7,1)
        (7,0) (6,1) (7,1) we see that (6,1) has not disturbed k for both the seven's as it is smaller than them. So we make taller reach their respective positons first by sorting */

        for(int [] each : people)
            result.add(each[1], each);
        return result.toArray(new int[people.length][2]);
    }
//    public static int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, (n1, n2)->(n1[0] == n2[0] ? n1[1]-n2[1] : n2[0]- n1[0]));
//        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
//        for(int i=0;i<people.length;i++){
//            arr.add(new ArrayList<>());
//            arr.get(i).add(people[i][0]);
//            arr.get(i).add(people[i][1]);
//        }
//      //  System.out.println(arr);
//        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
//        for(int i=0;i<arr.size();i++){
//            res.add(arr.get(i).get(1),arr.get(i));
//        }
//       // System.out.println(res);
//        int result[][]=new int[people.length][2];
//        for(int i=0;i<res.size();i++){
//            result[i][0]=res.get(i).get(0);
//            result[i][1]=res.get(i).get(1);
//        }
//        return result;
//    }
    public static void main(String[] args) {
        int arr[][]={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int res[][]=reconstructQueue(arr);

    }
}
