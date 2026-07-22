import java.util.HashMap;

class Solution {

    public int longestKSubstr(String s, int k) {

        if (s == null || s.length() < k || k == 0) {
            return -1;
        }

        int left = 0;
        int maxLength = -1;

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char incomingCharacter = s.charAt(right);

            frequencyMap.put(
                    incomingCharacter,
                    frequencyMap.getOrDefault(incomingCharacter, 0) + 1
            );

            while (frequencyMap.size() > k) {

                char outgoingCharacter = s.charAt(left);

                frequencyMap.put(
                        outgoingCharacter,
                        frequencyMap.get(outgoingCharacter) - 1
                );

                if (frequencyMap.get(outgoingCharacter) == 0) {
                    frequencyMap.remove(outgoingCharacter);
                }

                left++;
            }

            if (frequencyMap.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}