package _1023;

public class Solution {
    // Use Java built-in method to convert int to binary
    public boolean queryString1(String S, int N) {
        if (N < 1) return false;

        for (int i = 1; i <= N; i++) {
            String sub = Integer.toString(i, 2);
            if (!S.contains(sub)) return false;
        }
        return true;
    }


    private String toBinary(int N) {
        StringBuilder binary = new StringBuilder();
        do {
            int mod = N % 2;
            binary.append(String.valueOf(mod));
            N = (N - mod) / 2;
        } while (N >= 1);
        return binary.reverse().toString();
    }


    // Implement int to binary without built-in method
    public boolean queryString(String S, int N) {
        if (N < 1) return false;

        for (int i = 1; i <= N; i++) {
            String sub = toBinary(i);
            System.out.println("i " + i + " - binary " + sub);
            if (!S.contains(sub)) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();

//        System.out.println(10 % 3);
        System.out.println(sol.queryString("0110", 4));
    }
}
