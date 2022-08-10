public class Pow {

    /*
    https://leetcode.com/problems/powx-n/
     */
    public static void main(String[] args) {
        System.out.println(myPow2(8.95371,-1));
    }

    /*
    Too slow. My method was just horrible, refresh with recursive problems. Just awful
     */
    public static double myPow(double x, int n) {
        if (x == -1) return x;
        if (x == 1) return x;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        boolean isNegative = n < 0 ? true : false;
        n = Math.abs(n);

        double sum = x;

        while (n > 1) {
            sum *= x;
            n--;
        }

        return isNegative ? 1.0 / sum : sum;
    }

    /*
    Too slow.
     */
    public static double myPow2(double x, int n) {

        if (n == 0) return 1;

        boolean isNegative = n < 0 ? true : false;
        n = Math.abs(n);

        boolean isEven = n % 2 == 0;
        if (!isEven) n--;

        int levels = (int)customLog(2, n);

        int q = (int)Math.pow(2, levels);

        // This is cheating.
        int leftover = 0;



        if (n != (int)Math.pow(2, levels)) {
            leftover = n - (int)Math.pow(2, levels);
        }

        System.out.println("level: " + levels);

        double treeSum = x;
        while (levels > 0) {
            treeSum *= treeSum;

            levels--;
        }



        while (leftover > 0) {
            treeSum *= x;
            leftover--;
        }

        if (!isEven) treeSum *= x;
        System.out.println("treesum: " + treeSum);
        return isNegative ? 1.0 / treeSum : treeSum;
    }

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    /*
    if (n == 0) return 1;
        if (n < 0){
            x = 1/x;
            return (n %2 == 0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }
        return (n %2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
     */
}
