package leetcode.easy;

// https://leetcode.com/problems/range-sum-query-immutable/
// Dynamic programming
class NumArray {
    private final int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}