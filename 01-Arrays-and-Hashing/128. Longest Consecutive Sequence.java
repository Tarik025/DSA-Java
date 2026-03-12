import java.util.*;

public class LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence/description/

    public static int longestConsecutive(int[] nums) {
       if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int counter = 1;
        int max = 0;

        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    counter++;
                }
                else{
                    max = Math.max(max, counter);
                    counter = 1;
                }
            }
        }
        return Math.max(max, counter); 
    }

    public static void main(String[] args) {
        int [] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        longestConsecutive(nums);
    }
}
