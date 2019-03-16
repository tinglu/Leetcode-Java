package _380;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class RandomizedSet {
    List<Integer>[] set;
    int size = 256;
//    int count = 0;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new List[size];
        random = new Random();
    }

//    public void doubleSize() {
//        size = size * 2;
//        List<Integer>[] newSet = new List[size];
//        for (int i = 0; i < set.length; i++) {
//            newSet[i] = set[i];
//        }
//        set = newSet;
//    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
//        if (count > size) {
//            doubleSize();
//        }

        int idx = Math.abs(val) % size;
        if (set[idx] == null) {
            set[idx] = new LinkedList<>();
        }

        boolean found = false;
        for (int i : set[idx]) {
            if (i == val) {
                found = true;
                break;
            }
        }

        if (found) {
            return false;
        } else {
            set[idx].add(val);
//            count++;
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        int idx = Math.abs(val) % size;

        if (set[idx] == null) return false;

        for (int i = 0; i < set[idx].size(); i++) {
            if (set[idx].get(i) == val) {
                set[idx].remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = random.nextInt(size);
        if (set[i] == null) return getRandom();
        int bucketSize = set[i].size();
        if (bucketSize == 0) return getRandom();
        int j = random.nextInt(bucketSize);
        return set[i].get(j);
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(-1));

        // Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(-2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(-2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1));

        // 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
