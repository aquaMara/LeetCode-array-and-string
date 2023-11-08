package org.aquamara.two_pointer_technique;

// Minimum Size Subarray Sum
// 10/23/2023
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
public class $$MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int i3 = minSubArrayLen(6, new int[]{2, 3, 1, 2, 4, 3});
        int i1 = minSubArrayLen(4, new int[]{1, 4, 4});
        int i2 = minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1;
        int sum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                result = Math.min(result, i + 1 - left);

                sum -= nums[left];
                ++left;
            }
        }

        return result != nums.length + 1 ? result : 0;
    }

    public static int minSubArrayLenXXX(int target, int[] nums) {
        int length = nums.length;
        int minLength = length;
        int tempLength = 0;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                sum += nums[j];
                ++tempLength;
                if (sum >= target) {
                    minLength = Math.min(minLength, tempLength);
                    tempLength = 0;
                    sum = 0;
                    break;
                }
            }
            if (i == 0 && tempLength == length)
                return 0;
        }

        return minLength;
    }
}

/*
Given an array of positive integers nums and a positive integer target, return
the minimal length of a subarraywhose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
*/
