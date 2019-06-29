package MockP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// !!! XXX TIMEOUT!!!
// TODO: maybe consider use an Interval class
public class AddBoldTagsToString {

    public String addBoldTag(String s, String[] dict) {
        List<int[]> pos = positions(s, dict);
        if (pos.size() < 1) return s;
        List<int[]> merged = mergePos(pos);

        StringBuilder sb = new StringBuilder();
        int from = 0;
        for (int[] indices : merged) {
            if (from < indices[0]) {
                sb.append(s.substring(from, indices[0]));
            }
            sb.append("<b>");
            sb.append(s.substring(indices[0], indices[1] + 1));
            sb.append("</b>");
            from = indices[1] + 1;
        }
        if (from <= s.length() - 1) {
            sb.append(s.substring(from));
        }
        return sb.toString();
    }

    private List<int[]> positions(String s, String[] dict) {
        List<int[]> pos = new ArrayList<>();
        for (String pattern : dict) {
            int startFrom = 0;

            while (startFrom < s.length()) {
                int from = s.indexOf(pattern, startFrom);
                int to = from + pattern.length();
                pos.add(new int[]{from, to});
                startFrom = to + 1;
            }
        }
        return pos;
    }

    private List<int[]> mergePos(List<int[]> indices) {
        List<int[]> merged = new ArrayList<>();

        if (indices.size() < 1) return merged;

        Collections.sort(indices, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[1];
            }
        });

        int from = indices.get(0)[0];
        int to = indices.get(0)[1];

        for (int[] curr : indices) {
            if (curr[0] <= to) {
                if (curr[1] > to) {
                    to = curr[1];
                }
            } else {
                merged.add(new int[]{from, to});
                from = curr[0];
                to = curr[1];
            }
        }
        merged.add(new int[]{from, to}); // add the last group
        return merged;
    }

    public static void main(String[] args) {
        AddBoldTagsToString sol = new AddBoldTagsToString();

        String[] dict = {"abc", "123"};
        System.out.println(sol.addBoldTag("abcxyz123", dict));

        String[] dict2 = {"d"};
        System.out.println(sol.addBoldTag("aaabbcc", dict2));
    }
}
