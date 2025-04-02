import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class GroupAnagram {
    // https://leetcode.com/problems/group-anagrams/description/

    public List<List<String>> groupAnagrams(String[] strs) {
        // if(strs.length == 0){
        //     return new ArrayList<>();
        // }
        // if(strs.length == 1){
        //     List<List<String>> result = new ArrayList<>();
        //     List <String> L = new ArrayList<>();
        //     L.add(strs[0]);
        //     result.add(L);
        //     return result; 
        //     }
        //     HashMap <Character, Integer> map = new HashMap<>();
        //     for(int i = 0; i<strs.length; i++){
        //         char [] charArray = strs[i].toCharArray();
        //         System.out.println(charArray);
        //         for(int j = 0; j<strs.length; j++){
        //             map.put(charArray[j], j);
        //         }
        //     }
        //     System.out.println(map);
        //     for(int i = 0; i<strs.length; i++){
        //         char CheckKey = charArray[i];
        //         if(map.containsKey(CheckKey)){
        //         }
        //     }
        // return null;

//Leetcode:
        // Map<String><List<String>> map = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String tarik: strs){
            char [] charArray = tarik.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

    //main logic 
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>()); // 
            }

            // map.get(sortedString);
            // map.add(tarik);
            map.get(sortedString).add(tarik);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagram obj = new GroupAnagram();
        obj.groupAnagrams(strs);
        System.out.println(obj.groupAnagrams(strs));

    }
}

