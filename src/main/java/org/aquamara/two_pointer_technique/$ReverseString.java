package org.aquamara.two_pointer_technique;

// Reverse String
// 10/15/2023
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
public class $ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
        reverseString(new char[]{'H','a','n','n','a','h'});

        int[] v1 = {1, 2, 3, 4, 5, 6};
        int[] v2 = {0, 1, 2, 3, 4, 5, 6};
        reverse(v1);
        reverse(v2);
    }

    public static void reverseString(char[] s) {
        int firstPointer = 0;
        int lastPointer = s.length - 1;
        char temp = 0;
        while (firstPointer < lastPointer) {
            temp = s[firstPointer];
            s[firstPointer] = s[lastPointer];
            s[lastPointer] = temp;
            ++firstPointer;
            --lastPointer;
        }
    }

    public static void reverseString22(char[] s) {
        int lastPointer = s.length - 1;
        int times = s.length/2;
        char temp = 'a';
        for (int i = 0; times > 0; i++) {
            temp = s[i];
            s[i] = s[lastPointer];
            s[lastPointer] = temp;
            lastPointer--;
            times--;
        }
    }

    public static void reverse(int[] v) {
        int firstPointer = 0;
        int lastPointer = v.length - 1;
        while (firstPointer < lastPointer) {
            swap(v, firstPointer, lastPointer);
            ++firstPointer;
            --lastPointer;
        }
    }

    public static void swap(int[] v, int firstPointer, int lastPointer) {
        int temp = v[firstPointer];
        v[firstPointer] = v[lastPointer];
        v[lastPointer] = temp;
    }
}

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
*/
