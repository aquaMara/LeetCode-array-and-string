package org.aquamara.two_pointer_technique;

// Max Consecutive Ones
// 10/16/2023
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int maxConsecutiveOnes = findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        int maxConsecutiveOnes1 = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int tempConsecutive = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                maxConsecutive = Math.max(maxConsecutive, tempConsecutive);
                tempConsecutive = 0;
            } else {
                ++tempConsecutive;
            }
        }
        return Math.max(maxConsecutive, tempConsecutive);
    }
}

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/
