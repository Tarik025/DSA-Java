/**
 * Problem: Maximum Number of Vowels in a Substring of Given Length
 * Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * Type: Sliding Window (Fixed Size)
 *
 * Approach:
 * Maintain a fixed-size window of length k.
 * Count vowels entering the window and remove vowels leaving the window.
 * Track the maximum number of vowels seen in any valid window.
 *
 * Why:
 * Instead of counting vowels for every substring separately,
 * we update the count incrementally while sliding the window,
 * reducing the complexity from O(n × k) to O(n).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    // Returns true if the given character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    }

    public int maxVowels(String s, int k) {

        if (s == null || s.length() < k) {
            return 0;
        }

        int currentVowelCount = 0;
        int maxVowelCount = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add incoming character
            if (isVowel(s.charAt(right))) {
                currentVowelCount++;
            }

            // Process window when its size becomes k
            if (right - left + 1 == k) {

                maxVowelCount = Math.max(maxVowelCount, currentVowelCount);

                // Remove outgoing character
                if (isVowel(s.charAt(left))) {
                    currentVowelCount--;
                }

                left++;
            }
        }

        return maxVowelCount;
    }
}