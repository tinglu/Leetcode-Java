import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public static List<Integer> quickSort(List<Integer> ls) {
        if (ls.size() <= 1) {
            return ls;
        } else {
            int pivot = ls.get(0);

            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            int curr;
            for (int i = 1; i < ls.size(); i++) {
                curr = ls.get(i);
                if (curr <= pivot) {
                    left.add(curr);
                } else {
                    right.add(curr);
                }
            }

            List<Integer> merged = new ArrayList<>(quickSort(left));
            List<Integer> sortedRight = quickSort(right);
            sortedRight.add(0, pivot);
            merged.addAll(sortedRight);
            return merged;
        }
    }
}
