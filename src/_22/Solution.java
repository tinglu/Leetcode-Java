package _22;

import java.util.ArrayList;
import java.util.List;

class Solution {

    //    Brute force
    //    public List<String> generateParenthesis(int n) {
    //        if (n < 1) {
    //            return null;
    //        } else {
    //            List<String> parens = new ArrayList<>();
    //            parens.add("()");
    //            return _generateParenthesis(n, parens);
    //        }
    //    }
    //
    //    public List<String> _generateParenthesis(int n, List<String> ls) {
    //        if (n == 1) {
    //            return ls;
    //        } else {
    //            List<String> ns = new ArrayList<>();
    //            for (String s : ls) {
    //                int sLen = s.length();
    //                String tmp;
    //                for (int i=1; i < sLen; i++) {
    //                    tmp = s.substring(0, i) + "()" + s.substring(i, sLen);
    //                    if (!ns.contains(tmp)) {
    //                        ns.add(tmp);
    //                    }
    //                }
    //                String addToEnd = s + "()";
    //                if (!ns.contains(addToEnd)) {
    //                    ns.add(addToEnd);
    //                }
    //            }
    //            return _generateParenthesis(n-1, ns);
    //        }
    //    }


    //    Backtrack
    public List<String> generateParenthesis(int n) {
        List<String> parens = new ArrayList<>();
        _generateParenthesis(parens, "", n, 0, 0);
        return parens;
    }

    public void _generateParenthesis(List<String> ls, String curr, int max, int open, int close) {
        if (curr.length() == max * 2) {
            ls.add(curr);
            return;
        }

        if (open < max) {
            _generateParenthesis(ls, curr + '(', max, open + 1, close);
        }

        if (close < open) {
            _generateParenthesis(ls, curr + ")", max, open, close + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ls = solution.generateParenthesis(3);
        for (String s : ls) {
            System.out.println(s);
        }
    }
}