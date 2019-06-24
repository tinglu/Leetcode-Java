package MockP2;

// 941. Valid Mountain Array
public class MountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;

        if (A[1] < A[0]) return false;

        boolean peak = false;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                peak = true;
            }
            if (peak && A[i] >= A[i - 1]) {
                return false;
            }
        }
        return peak;
    }
}
