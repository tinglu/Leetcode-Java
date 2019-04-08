import java.util.*;

public class TestComparator {
    public static Map<Integer, Integer> sort1(List<Map<Integer, Integer>> maps, int k) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> result = new HashMap<>();
        for (Map<Integer, Integer> map : maps) {
            if (map.containsKey(k) && map.get(k) < min) {
                min = map.get(k);
                result = map;
            }
        }

        return result;
    }

    public static Map<Integer, Integer> sort2(List<Map<Integer, Integer>> maps, int k, String ord) {
        if (ord.equals("DSC")) {
            int max = Integer.MIN_VALUE;
            Map<Integer, Integer> result = new HashMap<>();
            for (Map<Integer, Integer> map : maps) {
                if (map.containsKey(k) && map.get(k) > max) {
                    max = map.get(k);
                    result = map;
                }
            }

            return result;
        } else {
//            ascending order by default
            return sort1(maps, k);
        }

    }


    public static Map<Integer, Integer> sort3(List<Map<Integer, Integer>> maps, List<Integer> keys, String ord) {
        if (maps.size() < 1) return null;
        if (maps.size() == 1) return maps.get(0);


        MapComparator2 comparator2 = new MapComparator2(ord, keys);
//        for (int i = 1; i < maps.size(); i++) {
//            if (maps.get(i-1).compare)
//        }

        maps.sort(comparator2);

        return maps.get(0);
    }


    public static void main(String[] args) {
        List<Map<Integer, Integer>> maps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);
        maps.add(map);
        map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        map.put(4, 400);
        map.put(5, 500);
        maps.add(map);

        System.out.println(sort1(maps, 2));

        System.out.println(sort2(maps, 2, "DSC"));

        List<Integer> keys = new ArrayList<>();
        keys.add(1);
        keys.add(2);
        System.out.println(sort3(maps, keys, "DSC"));
    }
}


class MapComparator1 implements Comparator<Map<Integer, Integer>> {
    String ord;
    int key;

    public MapComparator1(String o, int k) {
        ord = o;
        key = k;
    }


    @Override
    public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
        if (o1.containsKey(key) && o2.containsKey(key)) {
            return ord.equals("DSC") ? o2.get(key) - o1.get(key) : o1.get(key) - o2.get(key);
        }
        return 0;
    }
}

class MapComparator2 implements Comparator<Map<Integer, Integer>> {
    String ord;
    List<Integer> keys;

    public MapComparator2(String o, List<Integer> ks) {
        ord = o;
        keys = ks;
    }

    @Override
    public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
        int result = 0;
        for (int key : keys) {
            if (o1.containsKey(key) && o2.containsKey(key)) {
                result = ord.equals("DSC") ? o2.get(key) - o1.get(key) : o1.get(key) - o2.get(key);
                if (result != 0) return result;
            }
        }
        return result;
    }
}