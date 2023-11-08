package org.aquamara;

import java.util.Arrays;

// Reverse Words in a String
// 10/26/2023
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
public class $ReverseWordsInAString {

    public static void main(String[] args) {
        String s3 = reverseWords("a good   example");
        String s1 = reverseWords("the sky is blue");
        String s2 = reverseWords("  hello world  ");
    }
    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWords1(String s) {
        String[] strings = s.trim().split(" +");
        int first = 0;
        int last = strings.length - 1;
        String temp = "";
        while (first < last) {
            temp = strings[first];
            strings[first] = strings[last];
            strings[last]= temp;
            --last;
            ++first;
        }
        return Arrays.toString(strings)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }
}

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
