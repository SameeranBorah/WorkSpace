package Miscellaneous;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Random {
    public static void main(String[] args) throws FileNotFoundException {
        Random rand = new Random();
        PrintStream o = new PrintStream(new File("Dependency.txt"));
        for (int j = 0; j < 1000; j++)
        {
            System.setOut(o);
            System.out.println(rand.randomInteger(1 , 100)+"->"+rand.randomInteger(1 , 100));
//            pick++;
        }
    }
    public int randomInteger(int min, int max)
    {
        ArrayList<Integer> a=new ArrayList<>();

        java.security.SecureRandom rand = new java.security.SecureRandom();

        //get bounded [0, max) from nextInt()
        int randomNum = rand.nextInt(max) + min;

        return randomNum;
    }
    public static int numJewelsInStones(String J, String S) {
        int count=0;
        Set<Character> ch=new HashSet<>(J.length());
        for(int i=0;i<J.length();i++){
            ch.add(J.charAt(i));
        }
        for(int i=0;i<S.length();i++){
            if(ch.contains(S.charAt(i)))
                count++;
        }
        return count;
    }
    public int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[Math.abs(nums[i])]=-nums[nums[i]];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i;
        }
        return -1;
    }
}
