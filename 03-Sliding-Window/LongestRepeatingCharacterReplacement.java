/**
 * Problem: LeetCode 424 - Longest Repeating Character Replacement
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * * Approach: Sliding Window (Variable Size)
 * Why: We maintain a window and track the frequency of the most frequent character.
 * If (window_size - max_frequency > k), it means we need more than k replacements, 
 * so we shrink the window from the left.
 * 
 * * Time Complexity: O(N) - Single pass with two pointers.
 * Space Complexity: O(1) - Constant space for a 26-character frequency array.
 */

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update frequency of the current character
            count[s.charAt(right) - 'A']++;
            
            // Track the highest frequency in the current window
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // If (characters to be replaced > k), shrink window from left
            // Window Size = (right - left + 1)
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update global maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}