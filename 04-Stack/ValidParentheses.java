/**
 * Problem: LeetCode 20 - Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/
 * * Approach: Stack (LIFO)
 * Why: A stack is perfect for this because the last opening bracket 
 * encountered must be the first one closed. We push opening brackets and 
 * pop to match when a closing bracket appears.
 * * Time Complexity: O(N) - We traverse the string exactly once.
 * Space Complexity: O(N) - In the worst case (all opening brackets), 
 * the stack size will be N.
 */

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        // Use a Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If it's a closing bracket:
                // 1. Stack must not be empty
                // 2. The top of the stack must match the current closing bracket
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}