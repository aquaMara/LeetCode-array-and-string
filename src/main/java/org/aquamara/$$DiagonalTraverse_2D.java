package org.aquamara;

// Diagonal Traverse
// 7/10/2023
// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
public class $$DiagonalTraverse_2D {

    public static void main(String[] args) {
        int[] diagonalOrder1 = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[] diagonalOrder2 = findDiagonalOrder(new int[][]{{1, 2}, {3, 4}, {5, 6},{7, 8}});
        int[] diagonalOrder3 = findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int[] linear = new int[rows * columns];

        int row = 0, column = 0;
        int index = 0;
        boolean up = true;
        while (index < linear.length) {

            if (up) {
                while (row >= 0 && column < columns)
                    linear[index++] = mat[row--][column++];

                ++row;
                if (column >= columns) {
                    --column;
                    ++row;
                }
            } else {
                while (column >= 0 && row < rows)
                    linear[index++] = mat[row++][column--];

                ++column;
                if (row >= rows) {
                    ++column;
                    --row;
                }
            }
            up = !up;
        }

        return linear;
    }

    public static int[] findDiagonalOrder1(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int[] linear = new int[rows * columns];

        int row = 0, column = 0;
        int index = 0;
        boolean up = true;
        while (index < linear.length) {

            if (up) {
                while (row >= 0 && column < columns) {
                    linear[index++] = mat[row][column];
                    --row;
                    ++column;
                }
                if (column >= columns) {
                    --column;
                    row += 2;
                } else
                    ++row;
            } else {
                while (column >= 0 && row < rows) {
                    linear[index++] = mat[row][column];
                    --column;
                    ++row;
                }
                if (row >= rows) {
                    column += 2;
                    --row;
                } else
                    ++column;
            }
            up = !up;
        }

        return linear;
    }

    public static int[] findDiagonalOrder2(int[][] mat) {
        int rowLength = mat.length;
        int columnLength = mat[0].length;
        int[] linearMat = new int[rowLength * columnLength];

        int row = 0, column = 0;
        int index = 0;
        boolean up = true;
        while (row < rowLength && column < columnLength) {
            if (up) {
                while (row > 0 && column < columnLength - 1) {
                    linearMat[index++] = mat[row][column];
                    ++column;
                    --row;
                }
                linearMat[index++] = mat[row][column];
                if (column == columnLength - 1)
                    ++row;
                else
                    ++column;
            } else {
                while (column > 0 && row < rowLength - 1) {
                    linearMat[index++] = mat[row][column];
                    --column;
                    ++row;
                }
                linearMat[index++] = mat[row][column];
                if (row == rowLength - 1)
                    ++column;
                else
                    ++row;
            }
            up = !up;
        }
        return linearMat;
    }

}

/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

Example 2:
Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
*/
