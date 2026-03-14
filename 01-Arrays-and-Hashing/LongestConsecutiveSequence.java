/**
 * Problem: LeetCode 128 - Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * * Approach: Intelligent Set-based Sequence Building
 * Why: A Set allows O(1) lookups. We only start counting a sequence if the 
 * current number is the "start" of a sequence (i.e., num - 1 is not in the set).
 * This ensures each number is visited at most twice, maintaining O(N).
 * 
 * * Time Complexity: O(N) - Linear pass to build the set and a linear pass to find sequences.
 * Space Complexity: O(N) - To store all elements in the HashSet.
 */

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            // Check if 'num' is the start of a sequence
            // If (num - 1) exists, 'num' is NOT the start
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Build the sequence forward
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}