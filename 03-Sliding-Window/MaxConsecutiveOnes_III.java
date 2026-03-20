/**
 * Problem: LeetCode 1004 - Max Consecutive Ones III
 * Link: https://leetcode.com/problems/max-consecutive-ones-iii/
 * * Approach: Sliding Window (Variable Size)
 * Why: We expand the right pointer and count zeros. If our 'zeroCount' 
 * exceeds K, we shrink the left pointer until 'zeroCount' is <= K again.
 * * Time Complexity: O(N) - Each element is visited at most twice.
 * Space Complexity: O(1) - No extra data structures used.
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // If we encounter a zero, increment our zero counter
            if (nums[right] == 0) {
                zeros++;
            }

            // If we have more than one zero, shrink the window from the left
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // The window size is (right - left + 1). 
            // Since we must delete one element, the result is (right - left).
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}
