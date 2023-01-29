package leetcode.easy;


// https://leetcode.com/problems/single-number/
// Arrays, Bit manipulation
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}
