/**
 * Problem: Maximum Average Subarray I
 * Link: https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * Type: Sliding Window (Fixed Size)
 *
 * Approach:
 * Maintain a fixed-size sliding window of length k.
 * Track the maximum window sum while sliding the window.
 * Compute the average only once at the end.
 *
 * Why:
 * Instead of recalculating the sum for every subarray,
 * we reuse the previous window sum by removing the outgoing
 * element and adding the incoming element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

//Gemini, Optimize
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Safe to use Integer variables for current values since elements are ints
        int sum = 0;
        
        // Step 1: Initialize max with the lowest possible value to handle all-negative arrays safely
        int max = Integer.MIN_VALUE; 
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Expand window

            if (right - left + 1 == k) {
                // Track max sum instead of dividing here
                max = Math.max(max, sum);
                
                // Shrink window cleanly
                sum -= nums[left];
                left++;
            }
        }

        // Step 2: Perform the type-cast and division exactly ONCE at the return statement
        return (double) max / k;
    }
}

