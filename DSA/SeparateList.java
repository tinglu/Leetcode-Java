import java.util.LinkedList;

public class SeparateList {
    public static void separateLinkedList(LinkedList<Integer> ls, LinkedList<Integer> evenIdxList, LinkedList<Integer>
            oddIdxList) {
        int len = ls.size();
        if (len == 0) return;
        if (len == 1) {
            evenIdxList.add(ls.get(0));
        } else {
            int maxEvenIdx, maxOddIdx;
            if (len % 2 == 0) {
                maxEvenIdx = len - 2;
                maxOddIdx = len - 1;
            } else {
                maxEvenIdx = len - 1;
                maxOddIdx = len - 2;
            }

            for (int i = 0; i <= maxEvenIdx; i = i + 2) {
                evenIdxList.add(ls.get(i));
            }

            for (int j = maxOddIdx; j >= 1; j = j - 2) {
                oddIdxList.add(ls.get(j));
            }
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> ls = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            ls.add(i);
        }
        LinkedList<Integer> evenIdxList = new LinkedList<>();
        LinkedList<Integer> oddIdxList = new LinkedList<>();
        separateLinkedList(ls, evenIdxList, oddIdxList);
        Main.printList(ls);
        Main.printList(evenIdxList);
        Main.printList(oddIdxList);
    }
}
