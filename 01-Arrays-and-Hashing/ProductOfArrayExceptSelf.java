/**
 * Problem: LeetCode 238 - Product of Array Except Self
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 * * Approach: Left and Right Product (Prefix/Suffix) Logic
 * Time Complexity: O(N) - Two linear passes through the array.
 * Space Complexity: O(1) - If we don't count the output array as extra space (as per problem constraints).
 */

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: Calculate prefix products
        // result[i] will contain the product of all elements to the left of nums[i]
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Pass 2: Calculate suffix products on the fly
        // Multiply prefix products by the product of all elements to the right
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;
    }
}