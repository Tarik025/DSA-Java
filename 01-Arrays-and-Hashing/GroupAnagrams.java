/**
 * Problem: LeetCode 49 - Group Anagrams
 * Link: https://leetcode.com/problems/group-anagrams/
 * 
 * * Approach: Sorting as a Key (HashMap)
 * Why: Anagrams share the same characters. By sorting the characters of each string, 
 * we create a "signature" that is identical for all anagrams in a group.
 * 
 * * Time Complexity: O(N * K log K) 
 * - N is the number of strings.
 * - K is the maximum length of a string (Sorting takes K log K).
 * * Space Complexity: O(N * K) - To store the groups in the HashMap.
 */

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store: Key = Sorted String, Value = List of Anagrams
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array to sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);

            // If the sorted "signature" isn't in the map, create a new list
            if (!res.containsKey(sortedS)) {
                res.put(sortedS, new ArrayList<>());
            }
            
            // Add the original string to the matching group
            res.get(sortedS).add(s);
        }

        // Return all the lists stored in the map values
        return new ArrayList<>(res.values());
    }
}