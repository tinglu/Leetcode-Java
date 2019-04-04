package _1007;

//???????????????????
public class MinimusDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
//    public int minDominoRotations(int[] A, int[] B) {
//        if (A.length != B.length) return -1;
//
//        int count1 = rotations(A, B, A[0]);
//        int count2 = rotations(B, A, B[0]);
////        System.out.println("count1: " + count1);
////        System.out.println("count2: " + count2);
//        if (count1 == -1) return count2 > 0 ? count2 : -1;
//        if (count2 == -1) return count1 > 0 ? count1 : -1;
//        return count1 <= count2 ? count1 : count2;
//    }
//
//    private int rotations(int[] first, int[] second, int val) {
//        int count = 0;
//        for (int i = 1; i < first.length; i++) {
////            System.out.println("\ni: " + i);
////            System.out.println("first[i]: " + first[i]);
////            System.out.println("second[i]: " + second[i]);
//            if (first[i] != val) {
//                if (second[i] == val) {
//                    count += 1;
//                } else {
//                    return -1;
//                }
//            }
////            System.out.println("count: " + count);
//        }
//        return count;
//    }

    public static void main(String args[]) {
        MinimusDominoRotations sol = new MinimusDominoRotations();
        int[] A = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] B = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(sol.minDominoRotations(A, B));
    }
}
