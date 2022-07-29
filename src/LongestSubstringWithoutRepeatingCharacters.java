import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/

    This one made me pause more.

    initial thoughts:

    max length is # of unique characters in string

    look at index 0, push index forward until dupe character is found. save count
    then start with index 1, push forward, etc. if count > current count then replace

    THIS WAS SLOW ^

    so, lets cache how far the previous interation went, so we can just skip to the end of that.

    THIS WAS WRONG APPROACH - when in doubt use a hashmap. applies here.

    the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
    and keep two pointers which define the max substring. move the right pointer to scan through the string ,
    and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the
    right of the same character last found. Note that the two pointers can only move forward.


     */





    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdd"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int lastLength = 0;
        int maxLength = 0;
        int currentIndex = 0;

        // can be s.legnth - maxc or soemting
        while (currentIndex < s.length() - maxLength) {
            boolean isFirstRun = currentIndex == 0;

            int dummyIndex = isFirstRun ? currentIndex : currentIndex + lastLength - 1;
            int usedCharIndex = 0;
            char[] usedChars = new char[s.length()];

            System.out.printf("Curre: %d\n", currentIndex);
            System.out.printf("Dummy: %d\n\n", dummyIndex);

            while (dummyIndex < s.length() && !contains(s.charAt(dummyIndex), usedChars)) {
                usedChars[usedCharIndex] = s.charAt(dummyIndex);
                usedCharIndex++;
                dummyIndex++;
            }

            lastLength = length(usedChars) + lastLength - 1;
            if (lastLength > maxLength)
                maxLength = lastLength;

            currentIndex++;
        }

        return maxLength;

    }

    private static boolean contains(char c, char[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == c) return true;
        return false;
    }

    private static int length(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length && arr[i] != '\0'; i++)
            count++;
        return count;
    }

    public int realSolution(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i){
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    // faster solution is with int array instead of hashmap. size 256 for each character.
    public int bestCase(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }


}
