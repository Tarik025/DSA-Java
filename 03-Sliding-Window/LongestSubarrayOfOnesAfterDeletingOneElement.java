/**
 * Problem: Longest Subarray of 1's After Deleting One Element
 * Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 *
 * Type: Sliding Window (Variable Size)
 *
 * Approach:
 * Maintain a sliding window containing at most one zero.
 * Expand the window by moving the right pointer.
 * If more than one zero appears, shrink the window
 * until it again contains at most one zero.
 *
 * Since one element must always be deleted,
 * the answer is:
 *
 * windowLength - 1
 *
 * which is equivalent to:
 *
 * right - left
 *
 * Why:
 * The window always represents a valid segment where
 * deleting one zero (or one element if all are ones)
 * leaves the longest contiguous sequence of ones.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int longestSubarray(int[] nums) {

        int left = 0;
        int zeroCount = 0;
        int maximumLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maximumLength = Math.max(maximumLength, right - left);
        }

        return maximumLength;
    }
}