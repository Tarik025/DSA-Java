/**
 * Problem: Subarray Product Less Than K
 * Link: https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Type: Sliding Window (Variable Size)
 *
 * Approach:
 * Maintain a variable-size sliding window whose product is always
 * less than k. Expand the window by including the next element.
 * If the product becomes greater than or equal to k, shrink the
 * window from the left until the condition is satisfied again.
 *
 * Why:
 * Every subarray ending at the current index and starting anywhere
 * within the current valid window has a product less than k.
 * Therefore, the number of valid subarrays ending at 'right' is
 * exactly equal to the current window size.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // Product of positive integers can never be less than 1
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }

        int count = 0;
        int windowProduct = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand the window
            windowProduct *= nums[right];

            // Shrink the window until the product becomes valid
            while (windowProduct >= k) {
                windowProduct /= nums[left];
                left++;
            }

            // Count all valid subarrays ending at 'right'
            count += right - left + 1;
        }

        return count;
    }
}