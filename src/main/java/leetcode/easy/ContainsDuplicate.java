package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
// Arrays
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ints = new HashSet<>();
        for (int num : nums) {
            boolean isNew = ints.add(num);
            if (!isNew) return true;
        }
        return false;
    }
}
