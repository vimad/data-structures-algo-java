package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Arrays
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= nums.length; i++) {
            boolean isNew = numbers.add(i);
            if (isNew) list.add(i);
        }
        return list;
    }
}
