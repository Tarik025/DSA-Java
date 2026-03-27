/**
 * Problem: Decode String
 * Link: https://leetcode.com/problems/decode-string/
 *
 * Approach: Stack + StringBuilder
 *
 * Why:
 * We use a stack to handle nested encoded patterns.
 * When we encounter '[', we store the current string and number.
 * When we encounter ']', we build the decoded substring.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                // Build number (handles multi-digit like 12[a])
                k = k * 10 + (c - '0');
            }
            else if (c == '[') {
                // Push current state
                countStack.push(k);
                stringStack.push(currentString);

                // Reset
                currentString = new StringBuilder();
                k = 0;
            }
            else if (c == ']') {
                // Decode
                int repeat = countStack.pop();
                StringBuilder prevString = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prevString.append(currentString);
                }

                currentString = prevString;
            }
            else {
                // Normal character
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}