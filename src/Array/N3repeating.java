//package Array;
//
//import java.util.*;
//
//public class N3repeating {
//    public static int[] repeatedNumber(final List<Integer> arr) {
//        Map<Integer, Integer> mp = new HashMap<>();
//        int n=arr.size();
//        List<Integer> list = new ArrayList<>();
//        // Traverse through array elements and
//        // count frequencies
//        for (int i = 0; i < n; i++)
//        {
//            if (mp.containsKey(arr.get(i)))
//            {
//                mp.put(arr.get(i), mp.get(arr.get(i)) + 1);
//            }
//            else
//            {
//                mp.put(arr.get(i), 1);
//            }
//        }
//        // Traverse through map and print frequencies
//        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
//        {   if(entry.getValue()>(n/3))
//                list.add(entry.getKey());
//        }
//        if(list.size()==0)
//            list.add(-1);
//        int a[]=new int[list.size()];
//        for (int i = 0; i < list.size(); i++)
//        {
//            a[i] = list.get(i);
//        }
//        return a;
//    }
//    public static void main(String []args)
//    {
//        int arr[] = new int[]{ 10, 20, 20, 10, 10, 20, 5, 20};
//        List<Integer> list = new ArrayList<>(arr.length);
//
//        for (int i : arr) {
//            list.add(Integer.valueOf(i));
//        }
//        for(int i=0;i<repeatedNumber(list).size;i++)
//        int ar[]=new int[];
//        ar=
//    }
//}
