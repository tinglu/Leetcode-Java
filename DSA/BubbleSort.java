class BubbleSort {

    public static int[] bubbleSort(int[] ls) {
        int len = ls.length;
        if (len <= 1) {
            return ls;
        } else {
            int left, right, tmp;
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = 0; i < len - 1; i++) {
                    left = ls[i];
                    right = ls[i+1];
                    if (left > right) {
                        tmp = left;
                        ls[i] = right;
                        ls[i+1] = tmp;
                        swapped = true;
                    }
                }
                len--;
            }
            return ls;
        }
    }
}
