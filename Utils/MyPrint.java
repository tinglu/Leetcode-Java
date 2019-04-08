package Utils;

import java.util.List;
import java.util.Set;

public class MyPrint {
    public static void printSet(Set<int[]> results) {
        for (int[] p : results) {
            System.out.print(String.format("[%d,%d]", p[0], p[1]));
        }
        System.out.println("");
    }

    public static void printSetOfInt(Set<Integer> results) {
        for (int i : results) {
            System.out.print(String.format("%d, ", i));
        }
        System.out.println("");
    }

    public static void printListOfInt(List<Integer> results) {
        for (int i : results) {
            System.out.print(String.format("%d, ", i));
        }
        System.out.println("");
    }

    public static void print2DArray(int[][] A) {
        for (int[] p : A) {
            System.out.print(String.format("[%d,%d]", p[0], p[1]));
        }
        System.out.println("");
    }

    public static void printArray(int[] A) {
        for (int d : A) {
            System.out.print(String.format("%d, ", d));
        }
        System.out.println("");
    }
}
