/**
 * Problem: LeetCode 3 - Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * * Approach: Optimized Sliding Window (Two Pointers + HashMap)
 * Why: We use a HashMap to store the last seen index of each character. 
 * When we find a duplicate, we instantly "jump" the left pointer to the 
 * right of the previous occurrence, ensuring the window only contains unique characters.
 * 
 * * Time Complexity: O(N) - We traverse the string once with the right pointer.
 * Space Complexity: O(min(M, N)) - M is the size of the character set (charset).
 */

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we've seen this character before and it's inside our current window
            if (lastSeen.containsKey(currentChar)) {
                // Jump the left pointer to the right of the last occurrence
                left = Math.max(left, lastSeen.get(currentChar) + 1);
            }

            // Update the last seen index of the character
            lastSeen.put(currentChar, right);

            // Calculate the window size: (right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}