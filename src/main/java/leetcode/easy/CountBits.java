package leetcode.easy;


// https://leetcode.com/problems/counting-bits/
// Dynamic programming, Bit manipulation
public class CountBits {
    public int[] countBits(int n) {

        int lastTwoPow = 1;
        int nextTwoPow = 2;
        int[] result = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int mod = i % lastTwoPow;
            if (nextTwoPow == i) {
                result[i] = 1;
                lastTwoPow = nextTwoPow;
                nextTwoPow *= 2;
            } else {
                result[i] = 1 + result[mod];
            }
        }
        return result;
    }
}
