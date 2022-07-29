public class ZigZagConversion {

    /*
    https://leetcode.com/problems/zigzag-conversion/

    First try faster than 91% of submissions... good enough

    basically, determine gap between each letter in each row. look at each row, add each letter to stringbuilder.
    then repeat above for each row. Also knowing that the gap between each letter can alternate.
     */

    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int row1Gap = numRows * 2 - 2;

        // starts with 1.
        int currentRow = 0;
        int currentIndex = 0;

        StringBuilder builder = new StringBuilder();

        while (currentRow < numRows) {
            boolean useFirstGap = true;
            int firstGap = row1Gap - 2 * currentRow;
            int secondGap = row1Gap - firstGap;

            currentIndex = currentRow;
            while (currentIndex < s.length()) {
                builder.append(s.charAt(currentIndex));

                if (secondGap == 0) {
                    currentIndex += firstGap;
                } else if (firstGap == 0) {
                    currentIndex += secondGap;
                } else {
                    currentIndex += useFirstGap ? firstGap : secondGap;
                }
                useFirstGap = !useFirstGap;
            }
            currentRow++;
        }

        return builder.toString();

    }

}
