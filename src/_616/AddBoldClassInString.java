package _616;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddBoldClassInString {

    // TODO: re-do this question - my solution - Wrong!
    public String addBoldTag(String s, String[] dict) {
        if (dict.length < 1) return s;

        List<int[]> dictIdx = new ArrayList<>();

        int[] subIdx;
        for (String sub : dict) {
            int start = 0;
            while (start < s.length()) {
                subIdx = new int[2];
                if (s.startsWith(sub, start)) {
                    subIdx[0] = start;
                    subIdx[1] = subIdx[0] + sub.length() - 1;
                    dictIdx.add(subIdx);
                    start += sub.length();
                } else {
                    start++;
                }
            }
        }


        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };

        Collections.sort(dictIdx, comparator);

//        for (int[] part : dictIdx) {
//            System.out.print(Arrays.toString(part) + ", ");
//        }
//        System.out.println("\n" + s.length());

        if (dictIdx.size() < 1) return s;

        int from = dictIdx.get(0)[0], to = dictIdx.get(0)[1];
        List<int[]> newDictIdx = new ArrayList<>();
        for (int i = 0; i < dictIdx.size(); i++) {
            subIdx = dictIdx.get(i);
            if (subIdx[0] <= to + 1) {
                to = subIdx[1] < to ? to : subIdx[1];
            } else {
                int[] newSub = {from, to};
                newDictIdx.add(newSub);
                from = subIdx[0];
                to = subIdx[1];
            }
            if (i == dictIdx.size() - 1) {
                int[] newSub = {from, to};
                newDictIdx.add(newSub);
            }
        }

//        for (int[] part : newDictIdx) {
//            System.out.print(Arrays.toString(part) + ", ");
//        }
//        System.out.println("\n" + s.length());

        StringBuilder sb = new StringBuilder();
        int currEnd = 0;
        for (int[] idx : newDictIdx) {
            sb.append(s.substring(currEnd, idx[0]));
            sb.append("<b>");
//            System.out.println(Arrays.toString(idx));
            sb.append(s.substring(idx[0], idx[1] + 1));
            sb.append("</b>");
            currEnd = idx[1] + 1;
        }
        sb.append(s.substring(currEnd));

        return sb.toString();
    }


// Other's solution
//    public String addBoldTag(String S, String[] words) {
//        int N = S.length();
//        boolean[] mask = new boolean[N];
//        for (int i = 0; i < N; ++i)
//            for (String word : words)
//                search:{
//                    for (int k = 0; k < word.length(); ++k)
//                        if (k + i >= S.length() || S.charAt(k + i) != word.charAt(k))
//                            break search;
//
//                    for (int j = i; j < i + word.length(); ++j)
//                        mask[j] = true;
//                }
//
//        System.out.println(Arrays.toString(mask));
//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < N; ++i) {
//            if (mask[i] && (i == 0 || !mask[i - 1]))
//                ans.append("<b>");
//            ans.append(S.charAt(i));
//            if (mask[i] && (i == N - 1 || !mask[i + 1]))
//                ans.append("</b>");
//        }
//        return ans.toString();
//    }

    public static void main(String[] args) {
        AddBoldClassInString sol = new AddBoldClassInString();

        String[] dict = {"abc", "123"};
        System.out.println(sol.addBoldTag("abcxyz123", dict));

        String[] dict2 = {"d"};
        System.out.println(sol.addBoldTag("aaabbcc", dict2));

        String s =
                "hzancnmduvqhohvycltsgukoygoaxqzmyldpxdmstrekpbzdgecnzqcxjxzrpnilautomhqzbhdenoddiyosecznwedswiemuvkhirfvsstpsepsbfzrlrewzjpjlmjuuxpaetbsbhzyovedtkjblqlonxdvbaelwkdnudrokwomljcthbcqncxqizjpxjbbjffvhhlpiegoqbsvjrswbdeulqolmgxcueqdwycyrmbmkvddomvycbzepiqlavabmaqemefjqcnzucvoawcmbmglzzuyzidvfkcvhogmkwlomuesebcgefuabpnzqxhidllfunqrtpzklnfbalynxzkvkssikdgrfigkbcffrjlakkmcwwkuvbvkyxvcvvxthlubhmqyjdufcljfotmbcjoemgusxxiihhqwphvrjxonhofxuhkoaisrqzulecserfmadiobhiddtgqnewwkxlrxovvudeuzpcajjslhqotxwotzkclryrpsyhwf";
        String[] dict3 = {"hz", "an", "cn", "md", "uv", "qh", "oh", "vy", "cl", "ts", "gu", "ko", "yg", "oa", "xq",
                "zm", "yl", "dp", "xd", "ms", "tr", "ek", "pb", "zd", "ge", "zq", "cx", "jx", "zr", "pn", "il", "au",
                "to", "mh", "qz", "bh", "de", "no"};
        System.out.println(sol.addBoldTag(s, dict3));

        s = "aaabbcc";
        String[] dict4 = {"aaa", "aab", "bc", "aaabbcc"};
        System.out.println(sol.addBoldTag(s, dict4));

        String[] dict5 = {"aaabbcc"};
        System.out.println(sol.addBoldTag(s, dict5));


        String[] dict6 = {"a", "b", "c"};
        System.out.println(sol.addBoldTag(s, dict6));

//        String s = "baaa";
//        System.out.println(s.startsWith("aaa", 0));
//        System.out.println(s.startsWith("aaa", 1));
//        System.out.println(s.startsWith("aaa", 3));
    }
}
