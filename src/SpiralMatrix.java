import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
    https://leetcode.com/problems/spiral-matrix/
    [[1,2,3,4],[5,6,7,8],[9,10,11,12]]


    first solution 0ms, faster than 100%. but less memory than 50%.
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        List<Integer> list = spiralOrder(arr);
        System.out.println("\n\n\n\n----------------------");
        list.forEach(s -> System.out.println(s));


    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int minX = 0;
        int maxX = matrix[0].length;
        int minY = 0;
        int maxY = matrix.length;

        int currentX = 0;
        int currentY = 1;

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            currentX = minX;
            currentY = minY;

            boolean anyLocalChange = false;
            while (currentX < maxX) {
                list.add(matrix[currentY][currentX]);
                currentX++;
                anyLocalChange = true;
            }
            if (anyLocalChange) {
                currentY++;
                currentX--;
                if (minY + 1 <= maxY)
                    minY++;
            } else break;

            anyLocalChange = false;
            while (currentY < maxY) {
                list.add(matrix[currentY][currentX]);
                currentY++;
                anyLocalChange = true;
            }
            if (anyLocalChange) {
                currentX--;
                currentY--;
//                if (maxX - 1 >= minX) //-----
                    maxX--;
            } else break;

            anyLocalChange = false;
            while (currentX >= minX && currentY < maxY) {
                list.add(matrix[currentY][currentX]);
                currentX--;
                anyLocalChange = true;
            }
            if (anyLocalChange) {
                currentX++;
                currentY--;
//                if (maxY - 1 >= minY) //-----
                    maxY--;
            } else break;

            anyLocalChange = false;
            while (currentY >= minY && currentY < maxY) {
                list.add(matrix[currentY][currentX]);
                currentY--;
                anyLocalChange = true;
            }
            if (anyLocalChange) {
                currentX++;
                currentY++;
                if (minX + 1 <= maxX)
                    minX++;
            } else break;
        }
        return list;

    }

}
