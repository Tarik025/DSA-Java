/**
 * Problem: LeetCode 155 - Min Stack
 * Link: https://leetcode.com/problems/min-stack/
 * 
 * * Approach: Two-Stack Strategy (Main Stack + Min Stack)
 * Why: To achieve O(1) for getMin(), we maintain a secondary stack that 
 * keeps track of the minimum value at each "state" of the main stack.
 * 
 * * Time Complexity: O(1) for all operations (push, pop, top, getMin).
 * Space Complexity: O(N) to store the elements.
 */

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Push onto minStack if it's empty or val is <= current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // If the value being popped is the current minimum, pop from minStack too
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}