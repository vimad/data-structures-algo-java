package leetcode.easy;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/missing-number/
// Arrays, Bit manipulation
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i <= nums.length; i++) {
            boolean isNew = numbers.add(i);
            if (isNew) return i;
        }
        return -1;
    }
}
