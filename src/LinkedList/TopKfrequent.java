package LinkedList;

import javafx.util.Pair;
import jdk.internal.dynalink.linker.LinkerServices;

import javax.xml.bind.Element;
import java.util.*;
import java.util.stream.Collectors;

public class TopKfrequent {
    public static void main(String[] args) {
        int arr[]={1,1,1,2,2,3};
//        topKFrequent2(arr,2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
//        int a[]=new int[k];
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int num : nums){
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        System.out.println(map2);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int x : map2.keySet()){
            pq.offer(x);
            if(pq.size() > k){
                pq.poll();
            }
        }
        System.out.println(pq);
        int index = 0;
        while(!pq.isEmpty()){
            nums[index++] = pq.poll();
        }

        return Arrays.copyOfRange(nums, 0, index);
    }
}

//(a,b) -> map.get(a) - map.get(b)
