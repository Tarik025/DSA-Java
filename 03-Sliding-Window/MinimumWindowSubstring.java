/**
 * Problem: Minimum Window Substring
 * Link: https://leetcode.com/problems/minimum-window-substring/
 *
 * Approach: Sliding Window + HashMap
 * We use a sliding window with two pointers (left and right).
 * Expand the window until all required characters are matched.
 * Then shrink the window from the left to find the minimum valid substring.
 *
 * Key Idea:
 * "have" tracks how many unique characters meet required frequency.
 * "need" is total unique characters required.
 * When have == need → valid window.
 *
 * Time Complexity: O(N)
 * Each character is visited at most twice.
 * Space Complexity: O(K)
 * K = number of unique characters in string t.
 */


public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        // Edge case
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Build frequency map for string t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window variables
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        int have = 0;
        int need = tMap.size();

        // Step 3: Result tracking
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Step 4: Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char charRight = s.charAt(right);
            windowMap.put(charRight, windowMap.getOrDefault(charRight, 0) + 1);

            // Check if current character satisfies requirement
            if (tMap.containsKey(charRight) &&
                windowMap.get(charRight).intValue() == tMap.get(charRight).intValue()) {
                have++;
            }

            // Step 5: Shrink window when valid
            while (have == need) {

                // Update result
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = left;
                }

                char charLeft = s.charAt(left);

                // Remove left character from window
                windowMap.put(charLeft, windowMap.get(charLeft) - 1);

                // Check if window becomes invalid
                if (tMap.containsKey(charLeft) &&
                    windowMap.get(charLeft) < tMap.get(charLeft)) {
                    have--;
                }

                left++;
            }
        }

        // Step 6: Return result
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}