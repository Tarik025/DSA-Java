import java.util.*;

public class ValidAnagram {
    // https://leetcode.com/problems/valid-anagram/description/

    public boolean isAnagram(char s[], char t[]) {
               if (s.length() != t.length()) {
            System.out.println("lenght");
            return false;
        }
        char[] charArray = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        Arrays.sort(charArray);
        Arrays.sort(charArray2);

        if (charArray.length == charArray2.length) {
           for (int i = 0; i < charArray2.length; i++) {
                System.out.println("tarik");
                if (charArray[i] != charArray2[i]) {
                    return false;
                }
            }
    }
        return true;
    }

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        char[] charArray = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);
        Arrays.sort(charArray2);

        

        ValidAnagram obj = new ValidAnagram();

        System.out.println(obj.isAnagram(charArray, charArray2));
    }
}