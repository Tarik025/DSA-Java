class TwoSum {

    // https://leetcode.com/problems/two-sum/description/
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> Set = new HashMap<>();
        for(int i = 0; i<nums.length; i++){ //two pointer
            Set.put(nums[i], i);
        }
        for(int i = 0; i<nums.length; i++){
            int value = target - nums[i];
            if(Set.containsKey(value) && i != Set.get(value)){
                int result[] = {i, Set.get(value)};
                return result;
            }
        }
        return null;
    }       

}