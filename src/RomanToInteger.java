import java.util.HashMap;

public class RomanToInteger {

    /*
    https://leetcode.com/problems/roman-to-integer/

    Start at index 0, look right until biggest character is found. Sub left hand

    First attempt faster than 94%. Good to go.
    O(n)

    should include for edge case i suppose. couldnt ask tho bc description didnt say so. just ask
    if (s == null || s.length() == 0)
		return 0;

     */
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));


    }

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int total = 0;
        int currentIndex = 0;
        int lastValue = 0;
        int sectionSum = 0;

        while (currentIndex < s.length()) {

            int currentValue = map.get(s.charAt(currentIndex));

            // Stop and sum IV
            if (currentValue > lastValue) {
                sectionSum = currentValue - sectionSum;
                lastValue = currentValue;
            }

            // reset process VI
            else if (currentValue < lastValue) {
                total += sectionSum;
                sectionSum = currentValue;
                lastValue = currentValue;
                //lastValue = 0;
            }

            // same value II
            else {
                sectionSum += currentValue;
                lastValue = currentValue;
            }

            currentIndex++;
        }

        if (total == 0) return sectionSum;

        return total + sectionSum;
    }
}
