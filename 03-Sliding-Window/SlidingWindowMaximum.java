import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Sliding Window Maximum
 * Link: https://leetcode.com/problems/sliding-window-maximum/
 *
 * Type: Monotonic Queue (Deque)
 *
 * Approach:
 * Maintain a deque of indices whose corresponding values are
 * always in decreasing order.
 *
 * For every new element:
 * 1. Remove indices that are outside the current window.
 * 2. Remove all smaller elements from the back because they
 *    can never become the maximum again.
 * 3. Insert the current index.
 * 4. The front of the deque always stores the maximum element
 *    for the current window.
 *
 * Why:
 * Every index is inserted exactly once and removed at most once,
 * giving an overall O(n) solution.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] answer = new int[n - k + 1];

        int answerIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] <= nums[right]) {

                deque.pollLast();
            }

            // Insert current index
            deque.offerLast(right);

            // Record maximum once window reaches size k
            if (right >= k - 1) {
                answer[answerIndex++] = nums[deque.peekFirst()];
            }
        }

        return answer;
    }
}