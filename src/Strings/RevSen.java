package Strings;

public class RevSen {
    public static String solve(String str) {
        String[] splited = str.split(" ");
        StringBuffer s=new StringBuffer();

        if(splited.length==1)
            return str;
        else{
            for(int i=(splited.length-1);i>0;i--){
                s.append(splited[i]);
                s.append(" ");}
        }
        s.append(splited[0]);
        return s.toString();
    }

    public static void main(String[] args) {
        String str="I love you";
        System.out.println(solve(str));
    }
}
