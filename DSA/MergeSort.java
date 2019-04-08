import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] xs, int[] ys) {
        int x = 0;
        int y = 0;
        int z = 0;
        int[] zs = new int[xs.length + ys.length];
        while (z < xs.length + ys.length) {
            if (x == xs.length) {
                zs[z] = ys[y];
                y++;
            } else if (y == ys.length) {
                zs[z] = xs[x];
                x++;
            } else if (xs[x] <= ys[y]) {
                zs[z] = xs[x];
                x++;
            } else {
                zs[z] = ys[y];
                y++;
            }
            z++;
        }
        return zs;
    }

    public static int[] mergeSort(int[] ls) {
        int mid = ls.length / 2;
        if (mid == 0) {
            return ls;
        } else {
            return merge(mergeSort(Arrays.copyOfRange(ls, 0, mid)), mergeSort(Arrays.copyOfRange(ls, mid, ls.length)));
        }
    }
}
