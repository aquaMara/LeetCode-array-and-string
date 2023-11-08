package org.aquamara;

import java.util.ArrayList;
import java.util.List;

// Spiral Matrix
// 10/3/2023
// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
public class $$SpiralMatrix_2D {

    public static void main(String[] args) {
        List<Integer> integers = spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        List<Integer> integers1 = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> linear = new ArrayList<>();

        int beginRow = 0;
        int endRow = matrix.length - 1;
        int beginColumn = 0;
        int endColumn = matrix[0].length - 1;

        while (beginRow <= endRow && beginColumn <= endColumn) {

            for (int i = beginColumn; i <= endColumn; i++) {
                linear.add(matrix[beginRow][i]);
            }
            ++beginRow;

            for (int i = beginRow; i <= endRow; i++) {
                linear.add(matrix[i][endColumn]);
            }
            --endColumn;

            if (beginRow > endRow)
                continue;

            //if (beginRow <= endRow) {
                for (int i = endColumn; i >= beginColumn; i--) {
                    linear.add(matrix[endRow][i]);
                }
            //}
            --endRow;

            if (beginColumn > endColumn)
                continue;

            //if (beginColumn <= endColumn) {
                for (int i = endRow; i >= beginRow; i--) {
                    linear.add(matrix[i][beginColumn]);
                }
            //}
            ++beginColumn;
        }

        return linear;
    }
}

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
