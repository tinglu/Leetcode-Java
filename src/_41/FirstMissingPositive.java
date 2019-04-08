package _41;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
            if (n < small && n > 0) {
                big = small;
                small = n;
            } else if (n < big && n > 0){
                big = n;
            }
        }
        // System.out.println(small);
        int result = small > 1 ? 1 : small + 1;
        while(set.contains(result)){
            result +=1;
        }

        return result;
    }
}
