public class DivideTwoIntegers {

    /*
    https://leetcode.com/problems/divide-two-integers/


     */
    public static void main(String[] args) {
        System.out.println(divide(-1375621307
                ,-1102871504));
    }

    /*
    Completely wrong approach. Way too slow.
     */
    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        else if (dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
        else if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        else if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int count = 0;
        boolean isDividendNegative = false;
        boolean isDivisorNegative = false;

        if (dividend < 0) {
            isDividendNegative = true;
            dividend = dividend * -1;
        }
        if (divisor < 0) {
            isDivisorNegative = true;
            divisor *= -1;
        }

        while ((dividend -= divisor) >= 0) {
            if (count != Integer.MAX_VALUE)
                count++;
        }

        if ((isDividendNegative && !isDivisorNegative) || (isDivisorNegative && !isDividendNegative)) {
            count *= -1;
        }

        return count;
    }

    /*
    Proper solution is to use bit shifting. Look into this more.
     */
    public static int divide2(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        int sign = (dividend>=0) ^ (divisor>=0) ? -1:1; // this better way to determine sign than using two vars
        dividend = Math.abs(dividend); // better way to get positive value
        divisor = Math.abs(divisor);
        int res=0;
        while (dividend-divisor>=0){
            int x=0;
            while (dividend - (divisor<<1<<x) >=0) x++;
            res+=(1<<x);
            dividend-=(divisor<<x);
        }
        return res*sign;
    }

}
