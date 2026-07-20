/**
 * Problem: Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Type: Sliding Window (Variable Size)
 *
 * Approach:
 * Maintain a sliding window containing only unique characters.
 * Expand the window by adding the next character.
 * If a duplicate appears, shrink the window from the left
 * until the duplicate is removed.
 *
 * Why:
 * At every step, the current window contains only unique
 * characters. Track the maximum window length encountered
 * during the traversal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset))
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> window = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Remove duplicate characters
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            // Add current character
            window.add(s.charAt(right));

            // Update longest valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}