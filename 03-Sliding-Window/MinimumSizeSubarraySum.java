/**
 * Problem: LeetCode 209 - Minimum Size Subarray Sum
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 * * Approach: Sliding Window (Two Pointers)
 * Why: We expand the 'right' pointer to increase the window sum. Once the sum 
 * reaches or exceeds the target, we shrink the 'left' pointer to find the 
 * smallest possible window that still satisfies the condition.
 * * Time Complexity: O(N) - Each element is visited at most twice (once by each pointer).
 * Space Complexity: O(1) - Only a few variables used for tracking.
 */

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            // Expand the window by adding the current element
            currentSum += nums[right];

            // While the condition is met, try to shrink the window from the left
            while (currentSum >= target) {
                // Update the minimum length found so far
                minLength = Math.min(minLength, right - left + 1);
                
                // Shrink the window and move the left pointer
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, it means no such subarray exists
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}