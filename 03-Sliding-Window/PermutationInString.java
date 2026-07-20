/**
 * Problem: Permutation in String
 * Link: https://leetcode.com/problems/permutation-in-string/
 *
 * Type: Sliding Window (Fixed Size)
 *
 * Approach:
 * Build a frequency array for s1 and maintain a frequency array
 * for the current window in s2. Whenever the window size becomes
 * equal to s1.length(), compare both frequency arrays.
 * Return true immediately if they match.
 *
 * Why:
 * Instead of sorting every substring, we maintain character
 * frequencies while sliding the window. Since there are only
 * 26 lowercase English letters, comparing the frequency arrays
 * takes constant time.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        // Edge case
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] targetFrequency = new int[26];
        int[] windowFrequency = new int[26];

        // Build frequency map for s1
        for (char ch : s1.toCharArray()) {
            targetFrequency[ch - 'a']++;
        }

        int left = 0;
        int windowSize = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            // Add incoming character
            windowFrequency[s2.charAt(right) - 'a']++;

            // Process the window when its size becomes equal to s1.length()
            if (right - left + 1 == windowSize) {

                // Found a permutation
                if (Arrays.equals(targetFrequency, windowFrequency)) {
                    return true;
                }

                // Remove outgoing character
                windowFrequency[s2.charAt(left) - 'a']--;

                left++;
            }
        }

        return false;
    }
}