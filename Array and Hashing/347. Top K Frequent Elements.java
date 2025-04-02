import java.util.*;

class TopKFrequentElements {

    // https://leetcode.com/problems/top-k-frequent-elements/description/
        public int[] topKFrequent(int[] nums, int k) {
            Arrays.sort(nums);
            for (int ele  : nums) {
                System.out.print(ele+" ");
            }
                 PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);
            }
            System.out.println("\n"+pq);
    
            // ArrayList<Integer> list = new ArrayList<>(pq);
            // if(nums.length > 2){
            // for (int i = list.size() - 1; i > 0; i--) {
            //     if (!list.get(i).equals(list.get(i - 1))) {
            //         list.remove(i);   
            //     }
            // }
            // }
     // HashMap<Integer, Integer> map = new HashMap<>(pq);
     /* Why is it an error?
            * PriorityQueue<Integer> stores elements in a heap order (not key-value pairs).
            * HashMap<K, V> requires key-value pairs.
            * The constructor new HashMap<>(Collection<? extends Map.Entry<K, V>> c) does not exist. 
            */
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int value = pq.peek();
        if(!map.containsValue(value)){
            map.put(i, value);
        }
        pq.remove(pq.peek());
    }
            // if(k>map.size()){
            //     for(int i=0; i<nums.length; i++){
            //     int top = pq.peek();
            //     if(!list.contains(top)){
            //         map.add(top);
            //         System.out.println(map);
            //         if(map.size() == k) break;
            //     }
            //     pq.remove();
            //     }
            // }
            System.out.println(map);
    
            int [] result = new int[k];
            int index = 0;
            for (int i = 0; i<nums.length; i++) {
                result[index++] = nums[i];
                if (index == k)
                    break;
            }

            for (int i : result) {
                System.out.print(i+" ");
            }

            return result;
        }

    public static void main(String[] args) {
        int[] nums = { 5,2,5,3,5,3,1,1,3};
        int k = 10;
        TopKFrequentElements obj = new TopKFrequentElements();
        obj.topKFrequent(nums, k);
    }

}