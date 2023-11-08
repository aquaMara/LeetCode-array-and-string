package org.aquamara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Pascal's Triangle II
// 10/30/2023
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
public class _PascalsTriangleII {

    public static void main(String[] args) {
        List<Integer> row6 = getRow(6);  // 1 6 15 20 15 6 1
        List<Integer> row3 = getRow(3);  // 1 3 3 1
        List<Integer> row0 = getRow(0);  // 1
        List<Integer> row1 = getRow(1);  // 1 1
        List<Integer> row5 = getRow(5);  // 1 5 10 10 5 1
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long previous = 1;
        row.add((int) previous);

        for (int i = 1; i <= rowIndex; i++) {
            long current = (previous * (rowIndex + 1 - i)) / i;
            row.add((int) current);
            previous = current;
        }

        return row;
    }

    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> l=new ArrayList<>();

        List<Integer> first=new ArrayList<>();
        first.add(1);
        res.add(first);
        if(rowIndex==0)
        {
            return res.get(0);
        }
        for(int i=1;i<=rowIndex;i++)
        {
            List<Integer> prev=res.get(i-1);
            List<Integer> curr=new ArrayList<>();
            curr.add(1);
            for(int j=0;j<i-1;j++)
            {
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
            res.add(curr);
        }
        return res.get(rowIndex);
    }

    public static List<Integer> getRow222(int rowIndex) {
        List<Integer> first = List.of(1);
        List<Integer> second = new ArrayList<>(first);

        for (int i = 1; i <= rowIndex; i++) {
            second = new ArrayList<>();
            second.add(1);

            for (int j = 1; j < i; j++) {
                second.add(first.get(j) + first.get(j - 1));
            }
            second.add(1);
            first = second;
        }

        return second;
    }

    public static List<Integer> getRow22(int rowIndex) {
        Integer[] first = new Integer[]{1};
        Integer[] second = first;

        for (int i = 1; i <= rowIndex; i++) {
            second = new Integer[i + 1];
            second[0] = 1;
            second[i] = 1;

            for (int j = 1; j < i; j++) {
                second[j] = first[j] + first[j - 1];
            }
            first = second;
        }

        return Arrays.asList(second);
    }

    public static List<Integer> getRow2(int rowIndex) {
        // length of the row = rowIndex + 1
        int[] first = new int[]{1};
        int[] second = first;
        for (int i = 1; i <= rowIndex; i++) {
            second = new int[i + 1];
            second[0] = 1;
            second[i] = 1;
            for (int j = 1; j < i; j++) {
                second[j] = first[j] + first[j - 1];
            }
            first = second;
        }
        return Arrays.stream(second)
                .boxed()
                .toList();
    }
}

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]

Constraints:
0 <= rowIndex <= 33

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/
