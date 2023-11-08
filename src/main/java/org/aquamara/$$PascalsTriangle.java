package org.aquamara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Pascal's Triangle
// 10/7/2023
// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
public class $$PascalsTriangle {

    public static void main(String[] args) {

        List<List<Integer>> generate3 = generate(3);
        List<List<Integer>> generate1 = generate(1);
        List<List<Integer>> generate5 = generate(5);
    }

    public static List<List<Integer>> generateb(int numRows) {
        int[][] pascalsTriangle = new int[numRows][];

        for (int row = 0; row < numRows; row++) {
            int[] rowArr = new int[row + 1];
            rowArr[0] = 1;
            rowArr[row] = 1;

            for (int index = 1; index < row; index++) {
                int i = pascalsTriangle[row - 1][index - 1];
                int i1 = pascalsTriangle[row - 1][index];
                rowArr[index] = i + i1;
            }
            pascalsTriangle[row] = rowArr;
        }

        return (List) Arrays.asList(pascalsTriangle);
    }

    public static List<List<Integer>> generate(int numRows) {
        int[][] pascalTriangle = new int[numRows][];

        for (int row = 0; row < numRows; row++) {
            int[] rowArr = new int[row + 1];
            rowArr[0] = 1;
            rowArr[row] = 1;

            for (int index = 1; index < row; index++) {
                int i = pascalTriangle[row - 1][index - 1];
                int i1 = pascalTriangle[row - 1][index];
                rowArr[index] = i + i1;
            }

            pascalTriangle[row] = rowArr;
        }

        return (List) Arrays.asList(pascalTriangle);
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(List.of(1));

        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRowList = pascalsTriangle.get(row - 1);
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);

            for (int index = 1; index < row; index++)
                rowList.add(prevRowList.get(index - 1) + prevRowList.get(index));

            rowList.add(1);

            pascalsTriangle.add(rowList);
        }

        return pascalsTriangle;
    }
}

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
*/
