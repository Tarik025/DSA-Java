/**
 * Problem: LeetCode 242 - Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 * 
 * * Approach: Frequency Counter (Fixed-size Array)
 * Why: Since the problem specifies lowercase English letters, we use an 
 * integer array of size 26. This is more space-efficient than a HashMap.
 * 
 * * Time Complexity: O(N) - Where N is the length of the strings.
 * Space Complexity: O(1) - The array size is constant (26), regardless of input size.
 */

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase characters
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // Increment for string s, decrement for string t
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, it's an anagram
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}