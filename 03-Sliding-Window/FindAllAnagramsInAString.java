/**
 * Problem: Find All Anagrams in a String
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Type: Sliding Window (Fixed Size)
 *
 * Approach:
 * Build a frequency array for the target string (p) and maintain
 * a frequency array for the current window in string (s).
 * Compare both frequency arrays whenever the window size reaches p.length().
 *
 * Why:
 * Instead of sorting every substring or counting frequencies repeatedly,
 * we maintain a running frequency count while sliding the window.
 * Since the alphabet contains only 26 lowercase letters,
 * comparing both frequency arrays takes constant time.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // Edge case
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] targetFrequency = new int[26];
        int[] windowFrequency = new int[26];

        // Build target frequency map
        for (char ch : p.toCharArray()) {
            targetFrequency[ch - 'a']++;
        }

        int left = 0;
        int windowSize = p.length();

        for (int right = 0; right < s.length(); right++) {

            // Add incoming character
            windowFrequency[s.charAt(right) - 'a']++;

            // Process window when its size becomes equal to p.length()
            if (right - left + 1 == windowSize) {

                // Compare both frequency arrays
                if (Arrays.equals(targetFrequency, windowFrequency)) {
                    result.add(left);
                }

                // Remove outgoing character
                windowFrequency[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return result;
    }
}