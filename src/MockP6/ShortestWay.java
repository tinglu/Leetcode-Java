package MockP6;

/*
 *
 * TODO: review later - be careful about how index moving
 *
 * 1055. Shortest Way to Form String
 * https://leetcode.com/problems/shortest-way-to-form-string/
 *
 * */
public class ShortestWay {

    public int shortestWay(String source, String target) {

        int sLen = source.length();
        int tLen = target.length();

        int count = 0;

        int tId = 0;

        while (tId < tLen) {
            int tStartFrom = tId;

            for (int s = 0; s < sLen; s++) {
                if (tId < tLen && source.charAt(s) == target.charAt(tId)) {
                    tId++;
                }
            }

            if (tId == tStartFrom) {
                /*
                 * Didn't find any matching
                 *
                 * */
                return -1;
            }
            count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        ShortestWay sol = new ShortestWay();
        System.out.println(sol.shortestWay("abc", "abc"));
        System.out.println(sol.shortestWay("abc", "abcbc"));
        System.out.println(sol.shortestWay("xyz", "xzyxz"));
    }
}
