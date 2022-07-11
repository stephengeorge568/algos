public class isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(1221));
    }

    /*
        https://leetcode.com/problems/palindrome-number/

        First attempt

        Explained:
            Use modulo and division to compare the first, last index in the number.
            Increment and decrement these values respectively and compare each. If any diff, false.
            Else true. Stop comparing when startIndex is same or greater than endIndex.
            Edge cases handled in beginning.

        Runtime: 17 ms, faster than 34.02% of Java online submissions for Palindrome Number.
        Memory Usage: 41.7 MB, less than 89.98% of Java online submissions for Palindrome Number.

        Time Complexity: O(d/2) ? TODO
        Space Complexity: O(1) ?? TODO
        Slower because its just doing much more in each iteration?
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int endIndex = (int) (Math.log10(x) + 1) - 1;
        int startIndex = 0;

        while (startIndex < endIndex) {
            int start = (int) ((x / Math.pow(10,startIndex)) % 10);
            int end = (int) ((x / Math.pow(10,endIndex)) % 10);
            if (start != end) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

    /*
        After looking at best case solution

        Explained: In my attempt, I compared each index to its opposite pair. In this solution,
        the second half of the int was reversed and compared to the other half.

        Runtime: 9 ms, faster than 98.57% of Java online submissions for Palindrome Number.
        Memory Usage: 41.2 MB, less than 99.77% of Java online submissions for Palindrome Number.

        What was learned:

        Time Complexity: O(d/2)
        Space Complexity: O(1)

        https://www.code-recipe.com/post/palindrome-number
     */
    public static boolean isPalindrome2(int x) {

        // If x is a negative number it is not a palindrome
        // If x % 10 = 0, in order for it to be a palindrome the first digit should also be 0
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        // If x is equal to reversed number then it is a palindrome
        // If x has odd number of digits, dicard the middle digit before comparing with x
        // Example, if x = 23132, at the end of for loop x = 23 and reversedNum = 231
        // So, reversedNum/10 = 23, which is equal to x
        return (x == res || x == res / 10);
    }
}
