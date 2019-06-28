package MockP2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 833. Find And Replace in String
public class FindReplaceString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();

        if (indexes.length < 1) return S;
        if (indexes.length != sources.length || indexes.length != targets.length) return S;

        Map<Integer, Integer> indexesToSeq = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            indexesToSeq.put(indexes[i], i);
        }
        System.out.println("\nindexes: " + Arrays.toString(indexes));
        Arrays.sort(indexes);
        System.out.println("sorted: " + Arrays.toString(indexes));

        int from = 0;
        int to;
        for (int idx : indexes) {
            to = idx;
            System.out.println("\nfrom: " + from);
            System.out.println("to: " + to);

            int seq = indexesToSeq.get(idx);
            String source = sources[seq];
            String target = targets[seq];

            System.out.println("idx: " + idx);
            System.out.println("source: " + source);
            System.out.println("S.indexOf(source): " + S.indexOf(source, to)); // !!! IMPORTANT - FIND FROM CURRENT
            // POSITION

            if (S.indexOf(source, to) == idx) {
                if (to > from) {
                    sb.append(S.substring(from, to));
                }

                sb.append(target);
                from = idx + source.length();
                System.out.println("from: " + from);
            }
        }
        if (from < S.length()) {
            sb.append(S.substring(from));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindReplaceString sol = new FindReplaceString();

//        int[] indexes = {3, 5, 1};
//        String[] sources = {"kg", "ggq", "mo"};
//        String[] targets = {"s", "so", "bfr"};
//        String ans = sol.findReplaceString("vmokgggqzp", indexes, sources, targets);
//        System.out.println();
//        System.out.println(ans);
//        System.out.println("vbfrssozp");
//        System.out.println(ans.equals("vbfrssozp"));

        int[] indexes = {14, 12, 10, 5, 0, 18};
        String[] sources = {"rxv", "dh", "ui", "ttv", "wreor", "vo"};
        String[] targets = {"frs", "c", "ql", "qpir", "gwbeve", "n"};
        String ans = sol.findReplaceString("wreorttvosuidhrxvmvo", indexes, sources, targets);
        String exp = "gwbeveqpirosqlcfrsmn";
        System.out.println();
        System.out.println(ans);
        System.out.println(exp);
        System.out.println(ans.equals(exp));
    }
}
