/**
 * Problem: Binary Subarrays With Sum
 * Link: https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * Type: Sliding Window + At Most Trick
 *
 * Approach:
 * Instead of directly counting subarrays with sum exactly equal to goal,
 * count:
 *
 * 1. Subarrays with sum at most goal.
 * 2. Subarrays with sum at most (goal - 1).
 *
 * Their difference gives the number of subarrays whose sum is exactly goal.
 *
 * Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
 *
 * Why:
 * Sliding window efficiently counts subarrays with sum <= target
 * because the array contains only 0s and 1s (non-negative numbers).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    private int countAtMost(int[] nums, int target) {

        if (target < 0) {
            return 0;
        }

        int left = 0;
        int currentSum = 0;
        int subarrayCount = 0;

        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            while (currentSum > target) {
                currentSum -= nums[left];
                left++;
            }

            subarrayCount += right - left + 1;
        }

        return subarrayCount;
    }
}