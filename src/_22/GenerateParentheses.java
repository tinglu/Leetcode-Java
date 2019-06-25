package _22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenerateParentheses {

    // [2nd_time]
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", 0, 0, n, result);
        return result;
    }

    private void helper(String curr, int opened, int completed, int max, List<String> result) {
        if (curr.length() == max * 2) {
            result.add(curr);
            return;
        }

        /*
        *
        *
        * !!!! TODO - watch out here opened < max!!!
        *       as long as opened is < max, we can keep adding "("
        *
        * */
        if (opened < max) {
            helper(curr + "(", opened + 1, completed, max, result);
        }

        if (opened > completed) {
            helper(curr + ")", opened, completed + 1, max, result);
        }
    }

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
    public List<String> generateParenthesis1(int n) {
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
        GenerateParentheses solution = new GenerateParentheses();
        List<String> ls = solution.generateParenthesis(3);
        for (String s : ls) {
            System.out.println(s);
        }
    }
}