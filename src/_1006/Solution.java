package _1006;

public class Solution {
    //    https://leetcode.com/problems/clumsy-factorial/

    char[] operators = {'-', '*', '/', '+'};
    int optCount = operators.length;

    //    From right to left
    public int clumsy(int N) {
        int result = 0;
        int tmp = 1;
        int denominator = 1;

        if (N <= 0) return result;

        if (N == 1) return N;

        boolean intrimCalc = false;
        int optIdx;
        for (int i = 1; i <= N; i++) {
//            System.out.println();
//            System.out.println("i: " + i);

            optIdx = (N - i) % optCount;

            if (i == N) { // always *
                if (intrimCalc) {
                    tmp = tmp * i / denominator;
                    result += tmp;
                } else {
                    result = result * i;
                }
                return result;
            }

//            System.out.println("opt: " + operators[optIdx]);
            switch (operators[optIdx]) {
                case '+':
                    result += i;
                    break;
                case '-':
                    if (intrimCalc) {
                        tmp = 0 - tmp * i / denominator;
                        denominator = 1;
                        result += tmp;
                        tmp = 1;
                        intrimCalc = false;
                    } else {
                        result -= i;
                    }
                    break;
                case '/':
                    intrimCalc = true;
                    denominator = i;
                    break;
                case '*':
                    intrimCalc = true;
                    tmp = tmp * i;
                    break;
                default:
                    break;
            }
//            System.out.println("tmp: " + tmp);
//            System.out.println("result: " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.clumsy(1) == 1);
        System.out.println(solution.clumsy(2) == 2);
        System.out.println(solution.clumsy(3) == 6);
        System.out.println(solution.clumsy(4) == 7);
        System.out.println(solution.clumsy(5) == 7);
        System.out.println(solution.clumsy(6) == 8);
        System.out.println(solution.clumsy(7) == 6);
        System.out.println(solution.clumsy(8) == 9);
        System.out.println(solution.clumsy(9) == 11);
        System.out.println(solution.clumsy(10) == 12);
        System.out.println(solution.clumsy(6561) == 6563);
    }
}
