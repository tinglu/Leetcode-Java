package MyThread;

import java.util.Arrays;

public class MyString {
    //    1.2
    static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(sort(s));

        int a = 7;
        s = String.valueOf(a);
        System.out.println(s);
        System.out.println(Integer.parseInt(s));
    }
}
