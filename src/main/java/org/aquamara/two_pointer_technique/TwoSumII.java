package org.aquamara.two_pointer_technique;

import java.util.HashMap;
import java.util.Map;

// Two Sum II - Input array is sorted
// 10/16/2023
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
public class TwoSumII {

    public static void main(String[] args) {
        int[] ints1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ints2 = twoSum(new int[]{2, 3, 4}, 6);
        int[] ints3 = twoSum(new int[]{-1, 0}, -1);
    }

    // TWO SUM II
    public static int[] twoSum(int[] numbers, int target) { // 2 3 8 -> 10
        int firstPointer = 0;
        int lastPointer = numbers.length - 1;
        int sum = 0;

        while (firstPointer < lastPointer) {
            sum = numbers[firstPointer] + numbers[lastPointer];
            if (sum < target)
                firstPointer = findFirst(numbers, firstPointer, lastPointer, target - numbers[lastPointer]);
            else if (sum > target)
                lastPointer = findLast(numbers, firstPointer, lastPointer, target - numbers[firstPointer]);
            else
                return new int[]{firstPointer + 1, lastPointer + 1};
        }

        return null;
    }

    public static int findLeft(int[] nums, int start, int end, int target){
        while(start +1 < end){
            int mid = start + (end - start)/2;
            if(target < nums[mid]){
                end = mid;
            } else{
                start = mid;
            }
        }

        if(nums[start] == target){
            return start;
        }
        return end;
    }

    public static int findRight(int[] nums, int start, int end, int target){
        while(start +1  < end){
            int mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid;
            } else{
                end = mid;
            }
        }

        if(nums[end] == target){
            return end;
        }
        return start;
    }

    public static int findFirst(int[] numbers, int firstPointer, int lastPointer, int search) {
        int middle = 0;

        while (firstPointer < lastPointer) {
            middle = (firstPointer + lastPointer) / 2;

            if (numbers[middle] < search)
                firstPointer = middle;
            else if (numbers[middle] > search)
                lastPointer = middle;
            else
                return middle;

        }
        return lastPointer;
    }

    public static int findLast(int[] numbers, int firstPointer, int lastPointer, int search) {
        int middle = 0;

        while (firstPointer < lastPointer) {
            middle = (firstPointer + lastPointer) / 2;

            if (numbers[middle] < search)
                firstPointer = middle;
            else if (numbers[middle] > search)
                lastPointer = middle;
            else
                return middle;

        }
        return firstPointer;
    }


    // TWO SUM II
    public static int[] twoSum12(int[] numbers, int target) { // 2 3 8 -> 10
        int firstPointer = 0;
        int lastPointer = numbers.length - 1;
        int sum = 0;

        while (firstPointer < lastPointer) {
            sum = numbers[firstPointer] + numbers[lastPointer];
            if (sum < target)
                ++firstPointer;
            else if (sum > target)
                --lastPointer;
            else
                return new int[]{firstPointer + 1, lastPointer + 1};
        }

        return null;
    }

    // TWO SUM I
    public static int[] twoSum111(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = numbers.length;
        // key: which number do we need to find; value: index of current number
        // map tells us what we search for
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i]))
                return new int[]{i + 1, map.get(numbers[i]) + 1};
            map.put(target - numbers[i], i);
        }

        return null;
    }

    // TWO SUM I
    public static int[] twoSum11(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = numbers.length;
        // key: which number do we need to find; value: index of current number
        // map tells us what we search for
        for (int i = 0; i < length; i++) {
            map.put(target - numbers[i], i);
        }

        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i]))
                return new int[]{i + 1, map.get(numbers[i]) + 1};
        }

        return null;
    }

    // TWO SUM I
    public static int[] twoSum1(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
*/
