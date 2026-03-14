/**
 * Problem: LeetCode 11 - Container With Most Water
 * Link: https://leetcode.com/problems/container-with-most-water/
 * 
 * * Approach: Two Pointers
 * Why: We start with the maximum width and move the pointer that points 
 * to the shorter line, as moving the taller line's pointer can only 
 * decrease the area (since width decreases and height is limited by the shorter line).
 * 
 * * Time Complexity: O(N) - Single pass through the array.
 * Space Complexity: O(1) - Constant space used for pointers and area variable.
 */

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area: width * min(height[left], height[right])
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = currentWidth * currentHeight;
            
            // Update maxArea if current is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter bar
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}