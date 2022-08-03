public class ReverseInt {

    /*
    https://leetcode.com/problems/reverse-integer/
     */
    public int reverse(int x) {

        if (x == 0) return 0;
        boolean isNegative = x < 0 ? true : false;
        if (isNegative) x *= -1;
        int value = 0;
        int length = (int)(Math.log10(x)+1) - 1;
        int index = 0;
        int currentValue = 0;

        while (index <= length) {
            currentValue = (int)(x / Math.pow(10, index)) % 10;
            System.out.println(currentValue);
            if ((long)value + (long)currentValue *(long)Math.pow(10,length - index) > 2147483647) return 0;

            value += currentValue * Math.pow(10,length - index);
            index++;
        }
        if (isNegative) value *= -1;

        return value;

    }

    /*
    Original solution was slow and too much memory. Idea was correct. But it can be condensed and without mathematics
     */
    public int reverse2(int x) {

        long rev= 0;

        while( x != 0){

            rev= rev*10 + x % 10;

            x= x/10;

            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)

                return 0;

        }

        return (int) rev;

    }
}
