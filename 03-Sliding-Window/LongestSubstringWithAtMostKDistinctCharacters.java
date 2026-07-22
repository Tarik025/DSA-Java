import java.util.HashMap;

/**
 * Problem: Longest Substring with At Most K Distinct Characters
 * Link: https://www.naukri.com/code360/problems/distinct-characters_2221410
 *
 * Type: Sliding Window (Variable Size)
 *
 * Approach:
 * Maintain a sliding window with at most K distinct characters.
 * Expand the window by moving the right pointer.
 * If the number of distinct characters exceeds K,
 * shrink the window from the left until it becomes valid again.
 *
 * Why:
 * Instead of checking every possible substring,
 * the sliding window efficiently maintains a valid substring
 * with at most K distinct characters in O(n) time.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

import java.util.HashMap;

class Solution {

    public static int kDistinctChars(int k, String s) {

        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0;
        int maxLength = 0;

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char incomingCharacter = s.charAt(right);

            frequencyMap.put(
                    incomingCharacter,
                    frequencyMap.getOrDefault(incomingCharacter, 0) + 1
            );

            while (frequencyMap.size() > k) {

                char outgoingCharacter = s.charAt(left);

                frequencyMap.put(
                        outgoingCharacter,
                        frequencyMap.get(outgoingCharacter) - 1
                );

                if (frequencyMap.get(outgoingCharacter) == 0) {
                    frequencyMap.remove(outgoingCharacter);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}