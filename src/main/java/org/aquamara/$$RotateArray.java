package org.aquamara;

// Rotate Array
// 10/26/2023
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
public class $$RotateArray {

    public static void main(String[] args) {
        rotate(new int[]{-1,-100,3,99}, 5);
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
        rotate(new int[]{-1,-100,3,99}, 2);
    }

    public static void rotate(int[] nums, int k) {
        // k is the number of steps, not an index, may be greater
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    // Time Limit Exceeded
    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        while (k > 0) {
            int last = nums[length - 1];
            for (int i = length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
            --k;
        }
    }

    public static void swap(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = temp;
    }
}

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

Follow up:
Try to come up with as many solutions as you can.
There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
