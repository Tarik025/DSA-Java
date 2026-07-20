/**
 * Problem: Max Sum Subarray of Size K
 * Link: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 *
 * Type: Sliding Window (Fixed Size)
 *
 * Approach:
 * Maintain a fixed-size window of length k.
 * Add the incoming element and remove the outgoing element
 * while sliding the window across the array.
 *
 * Why:
 * Instead of recalculating the sum of every subarray,
 * we reuse the previous window sum, reducing the complexity
 * from O(n × k) to O(n).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class MaxSumSubarrayOfSizeK  {
    public int maxSubarraySum(int[] arr, int k) {
        // Edge case safety check
        if (arr == null || arr.length < k || k <= 0) return 0;

        int sum = 0;
        int max = Integer.MIN_VALUE; // Handles arrays with all negative numbers
        int left = 0;

        // The 'right' pointer dynamically expands the window
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right]; // Add the incoming element

            // Once the window size hits exactly K elements
            if (right - left + 1 == k) {
                // Update our global maximum
                max = Math.max(max, sum);
                
                // Shrink the window from the left: subtract the element left behind
                sum -= arr[left];
                left++; // Slide the left boundary forward
            }
        }

        return max;
    }
}

