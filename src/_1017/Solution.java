package _1017;

class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        if (N == 0) return "0";
        while (N != 0) {
//            System.out.println("\nN: " + N);
            int div = (int) Math.ceil((double) N / (-2));
            int r = N - div * (-2);
//            System.out.println("div: " + div + " r:" + r);
            N = div;
            sb.append(r);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.baseNeg2((int) Math.pow(10, 9)));
        System.out.println(sol.baseNeg2(1));
    }
}
