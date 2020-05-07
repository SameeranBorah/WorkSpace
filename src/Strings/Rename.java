package Strings;

public class Rename {
    public static void main(String[] args) {
        String str="abcd";
        rename(str);
        str.substring(1);

    }
    public static void rename( String str) {
        if (str.length() == 1) {
            System.out.println(str);
        } else {
            System.out.print(str.charAt(str.length()-1));
            rename(str.substring(0, str.length() - 1));
        }

    }
}


