/**
 * Problem: Subarrays with K Different Integers
 * Link: https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * Type: Sliding Window + At Most Trick
 *
 * Approach:
 * Count subarrays containing exactly K distinct integers using:
 *
 * Exactly(K) = AtMost(K) - AtMost(K - 1)
 *
 * The helper function counts all subarrays containing
 * at most the given number of distinct integers.
 *
 * Why:
 * Directly counting exactly K distinct elements is difficult.
 * Counting at most K is straightforward using a sliding window.
 * Subtracting AtMost(K - 1) leaves only subarrays with exactly K distinct integers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private int countAtMost(int[] nums, int maxDistinct) {

        if (maxDistinct <= 0) {
            return 0;
        }

        int left = 0;
        int distinctCount = 0;
        int totalSubarrays = 0;

        int[] frequency = new int[nums.length + 1];

        for (int right = 0; right < nums.length; right++) {

            if (frequency[nums[right]] == 0) {
                distinctCount++;
            }

            frequency[nums[right]]++;

            while (distinctCount > maxDistinct) {

                frequency[nums[left]]--;

                if (frequency[nums[left]] == 0) {
                    distinctCount--;
                }

                left++;
            }

            totalSubarrays += right - left + 1;
        }

        return totalSubarrays;
    }
}