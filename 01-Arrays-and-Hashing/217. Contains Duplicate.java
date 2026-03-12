class Solution {

    // https://leetcode.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> Set = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            Set.put(nums[i], i);
        }
        for(int i = 0; i<nums.length; i++){
            int value = nums[i];
            if(Set.containsKey(value) && i != Set.get(value)){
                return true;
            }
        }
        return false;
    }
}