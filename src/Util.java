import java.util.Set;

public class Util {
    void printSet(Set<int[]> results) {
        for (int[] p : results) {
            System.out.print(String.format("[%d,%d]", p[0], p[1]));
        }
        System.out.println("");
    }

    void printArray(int[][] A) {
        for (int[] p : A) {
            System.out.print(String.format("[%d,%d]", p[0], p[1]));
        }
        System.out.println("");
    }
}
