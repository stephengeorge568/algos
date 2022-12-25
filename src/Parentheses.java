import java.util.Stack;

public class Parentheses {

    /*
    https://leetcode.com/problems/valid-parentheses/
    {[(

    its good. code needs cleaned up tho. This can be rewritten much better
     */

    public static void main(String[] args) throws Exception {
        System.out.println(isValid("({[]}[])"));
    }

    public static boolean isValid(String s) throws Exception {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                if (!sameType(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean sameType(Character nextChar, Character stackPop) throws Exception {
        switch(nextChar) {
            case '{':
                return stackPop == '}';
            case '[':
                return stackPop == ']';
            case '(':
                return stackPop == ')';
            default:
                throw new Exception();
        }
    }

}
