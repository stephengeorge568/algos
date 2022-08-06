public class ContainerWithMostWater {

    /*
    https://leetcode.com/problems/container-with-most-water/
     */
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /*
    original solution was brute forced basically. This was far too slow, exceeded time. I expected this however.
    THen i decided to just skip to next column that is bigger than the shortest column currently in use.
    faster than 97%. uses hella memory though and i dont know why
     */
    public static int maxArea(int[] height) {
        int max = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);

            boolean minIsLeft = height[left] > height[right] ? false : true;


            if (w * h > max) {
                max = w * h;
            }

            // this can be shortened so much
            if (minIsLeft) {
                while (++left < right) {
                    if (height[left] > h) {
                        break;
                    }
                }
            } else {
                while (--right > left) {
                    if (height[right] > h) {
                        break;
                    }
                }
            }

        }

        return max;
    }

    /*
    Here is effectively same code, but much cleaner and shorter

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
     */



}
