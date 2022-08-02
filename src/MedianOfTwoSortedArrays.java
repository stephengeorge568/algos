public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println( findMedianSortedArrays(new int[]{}, new int[]{1}));
    }


    /*
    attempt 1, faster than 90%. memory usage less than 20%****
    this made me realize, i dont actually need to remember the first few elements. I can just get last or last 2 elemtsn
    and get median off that. <<<
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int stopCount = (nums1.length + nums2.length) / 2 + 1;

        int num1Count = 0;
        int num2Count = 0;

        int[] arr = new int[stopCount ];

        while (num1Count + num2Count < stopCount) {

            if (num1Count >= nums1.length) {
                arr[num1Count + num2Count] = nums2[num2Count];
                num2Count++;
            } else if (num2Count >= nums2.length) {
                arr[num1Count + num2Count] = nums1[num1Count];
                num1Count++;
            } else if (nums1[num1Count] < nums2[num2Count]) {
                arr[num1Count + num2Count] = nums1[num1Count];
                num1Count++;
            } else if (nums1[num1Count] > nums2[num2Count]){
                arr[num1Count + num2Count] = nums2[num2Count];
                num2Count++;
            } else {
                if (num1Count + num2Count < arr.length) {
                    arr[num1Count + num2Count] = nums1[num1Count];
                    num1Count++;
                }

                if (num1Count + num2Count < arr.length) {
                    arr[num1Count + num2Count] = nums2[num2Count];
                    num2Count++;
                }
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0 && arr.length > 1) {
            return ((double)arr[arr.length - 1] + (double)arr[arr.length - 2]) / 2;
        } else {
            return arr[arr.length - 1];
        }
    }
}
