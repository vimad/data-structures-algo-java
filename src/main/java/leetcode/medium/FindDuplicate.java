package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public FindDuplicate() {
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        System.out.println(set);
        return 0;
    }
}