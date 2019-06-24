package _247;

import java.util.*;

/*
 *
 * 247. Strobogrammatic Number II
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 *
 *
 *
 * expand from inside out instead!!!
 *
 * */
public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        return expandOutward(n, n);
    }

    private List<String> expandOutward(int totalSize, int remaining) {
        if (remaining == 0) return new ArrayList<>(Arrays.asList(""));
        if (remaining == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));


        List<String> innerStrings = expandOutward(totalSize, remaining - 2);
        List<String> result = new ArrayList<>();
        for (String inner : innerStrings) {
            if (remaining != totalSize) result.add("0" + inner + "0"); // 00 is not a valid number
            result.add("1" + inner + "1");
            result.add("8" + inner + "8");
            result.add("6" + inner + "9");
            result.add("9" + inner + "6");
        }
        return result;
    }

    public static void main(String[] main) {
        StrobogrammaticNumber2 sol = new StrobogrammaticNumber2();
        System.out.println(Arrays.toString(sol.findStrobogrammatic(1).toArray()));
        System.out.println(Arrays.toString(sol.findStrobogrammatic(2).toArray()));
        System.out.println(Arrays.toString(sol.findStrobogrammatic(3).toArray()));
        System.out.println(Arrays.toString(sol.findStrobogrammatic(4).toArray()));
    }
}

/*
 *
 * My original solution - TOO SLOW! - insert inside the outer strings
 * */
//public class StrobogrammaticNumber2 {
//    private Set<String> doubleStrobos;
//    private Set<String> validDoubles;
//    private Set<String> singleStrobos;
//
//    public List<String> findStrobogrammatic(int n) {
//        doubleStrobos = new HashSet<>();
//        doubleStrobos.add("00");
//        doubleStrobos.add("11");
//        doubleStrobos.add("88");
//        doubleStrobos.add("69");
//        doubleStrobos.add("96");
//
//        validDoubles = new HashSet<>();
//        validDoubles.add("11");
//        validDoubles.add("88");
//        validDoubles.add("69");
//        validDoubles.add("96");
//
//        singleStrobos = new HashSet<>();
//        singleStrobos.add("0");
//        singleStrobos.add("1");
//        singleStrobos.add("8");
//
//        return appendInside(n, new ArrayList<>());
//    }
//
//
//    private List<String> appendInside(int n, List<String> outer) {
//        if (n == 0) return outer;
//
//        List<String> result = new ArrayList<>();
//        if (n == 1) {
//            if (outer.isEmpty()) {
//                result = new ArrayList<>(singleStrobos);
//            } else {
//                for (String str : outer) {
//                    int mid = str.length() / 2;
//                    for (String s : singleStrobos) {
//                        result.add(str.substring(0, mid) + s + str.substring(mid));
//                    }
//                }
//            }
//            return appendInside(n - 1, result);
//        } else {
//            if (outer.isEmpty()) {
//                result = new ArrayList<>(validDoubles);
//            } else {
//                for (String str : outer) {
//                    int mid = str.length() / 2;
//                    for (String s : doubleStrobos) {
//                        result.add(str.substring(0, mid) + s + str.substring(mid));
//                    }
//                }
//            }
//            return appendInside(n - 2, result);
//        }
//    }
//
//    public static void main(String[] main) {
//        StrobogrammaticNumber2 sol = new StrobogrammaticNumber2();
//        System.out.println(Arrays.toString(sol.findStrobogrammatic(1).toArray()));
//        System.out.println(Arrays.toString(sol.findStrobogrammatic(2).toArray()));
//        System.out.println(Arrays.toString(sol.findStrobogrammatic(3).toArray()));
//        System.out.println(Arrays.toString(sol.findStrobogrammatic(4).toArray()));
//    }
//}
