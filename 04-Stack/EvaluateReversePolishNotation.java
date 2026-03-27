/**
 * Problem: Evaluate Reverse Polish Notation
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Approach: Stack
 *
 * Why:
 * We use a stack to store numbers.
 * When we encounter an operator, we pop two elements,
 * apply the operation, and push the result back.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // If operator → perform calculation
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand

                int result = 0;

                if (token.equals("+")) {
                    result = a + b;
                } else if (token.equals("-")) {
                    result = a - b;
                } else if (token.equals("*")) {
                    result = a * b;
                } else {
                    result = a / b;
                }

                stack.push(result);

            } else {
                // If number → push to stack
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}