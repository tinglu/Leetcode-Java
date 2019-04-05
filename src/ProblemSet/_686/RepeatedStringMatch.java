package ProblemSet._686;

class RepeatedStringMatch {
//    XXXX ???? not quite right???
//    public int repeatedStringMatch(String A, String B) {
//        if (A.equals("") || B.equals("")) return -1;
//
//        if (A.contains(B)) return 1;
//
//        int lenA = A.length();
//        int lenB = B.length();
//
//        if (B.contains(A)) {
//            if (A.charAt(0) == B.charAt(0)) {
////                System.out.println("??");
////                System.out.println("lenB: " + lenB);
////                System.out.println("lenA: " + lenA);
//                return (int) Math.ceil((float) lenB / lenA);
//            } else {
//                int i = B.indexOf(A.charAt((0)));
//                int j = B.lastIndexOf(A.charAt((lenA - 1)));
//                String subLeft = B.substring(0, i);
//                String subRight = B.substring(j + 1, lenB);
//
//
////                System.out.println("lenB: " + lenB);
////                System.out.println("lenA: " + lenA);
////                System.out.println("subLeft: " + subLeft);
////                System.out.println("subRight: " + subRight);
////                System.out.print("A.contains(subLeft) && A.contains(subRight): ");
////                System.out.println(A.contains(subLeft) && A.contains(subRight));
//
//                if (A.contains(subLeft) && A.contains(subRight)) {
//                    int first = A.indexOf(B.charAt(0));
//                    int last = A.indexOf(B.charAt(lenB - 1));
//                    return (lenB / lenA + (first-last));
//                } else {
//                    return -1;
//                }
//            }
//        }
//        return -1;
//    }

    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder sb = new StringBuilder(A);
        for (; sb.length() < B.length(); q++) sb.append(A);
        if (sb.indexOf(B) >= 0) return q;
        if (sb.append(A).indexOf(B) > 0) return q + 1;
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch sol = new RepeatedStringMatch();
        System.out.println(sol.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(sol.repeatedStringMatch("abbbb", "abbbbab"));
        System.out.println(sol.repeatedStringMatch("abc", "cabcabca"));
    }
}