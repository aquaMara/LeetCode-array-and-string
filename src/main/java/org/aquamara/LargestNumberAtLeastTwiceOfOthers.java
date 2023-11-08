package org.aquamara;

// Largest Number At Least Twice of Others
// 29/8/2023
// https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{2,2,3,4}));
        System.out.println(dominantIndex(new int[]{1,2,3,4}));
        System.out.println(dominantIndex(new int[]{5,1,2,3,4}));
        System.out.println(dominantIndex(new int[]{3,6,1,0}));
    }

    // what if max is the first number
    public static int dominantIndex(int[] nums) {
        int secondMaxIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (maxIndex == -1 || nums[i] > nums[maxIndex]) {
                secondMaxIndex = maxIndex;
                maxIndex = i;
            } else if ((secondMaxIndex == -1 || nums[i] > nums[secondMaxIndex]) && nums[maxIndex] != nums[i]) {
                secondMaxIndex = i;
            }
        }

        return nums[maxIndex] >= nums[secondMaxIndex] * 2 ? maxIndex: -1;
    }

    public static int dominantIndex1(int[] nums) {
        int max = -1, secondMax = -1;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max == -1 || nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if ((secondMax == -1 || nums[i] > secondMax) && max != nums[i]) {
                secondMax = nums[i];
            }
        }


        return max >= secondMax * 2 ? maxIndex: -1;
    }
}

/*
You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.

Example 2:
Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.

Constraints:
2 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.
*/
