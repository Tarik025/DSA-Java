/**
 * Problem: LeetCode 125 - Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome/
 * 
 * * Approach: Two Pointers (In-place)
 * Why: We avoid extra space complexity by not creating a reversed string.
 * We use Character.isLetterOrDigit() to skip punctuation and spaces.
 * 
 * * Time Complexity: O(N) - Single pass through the string.
 * Space Complexity: O(1) - No extra data structures used.
 */

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Step 1: Move left pointer until it hits an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Step 2: Move right pointer until it hits an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Step 3: Compare characters (ignoring case)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}