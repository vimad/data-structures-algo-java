package leetcode.easy;


//
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            if (currentSum > max) {
                max = currentSum;
            }
        }
        return max;
    }
}
