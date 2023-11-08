package org.aquamara;

// Reverse Words in a String III
// 10/26/2023
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
public class $ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s1 = reverseWords("God Ding");
        String s = reverseWords("Let's take LeetCode contest");
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;

        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            ++start;
            --end;
        }
    }

    public static String reverseWords11(String s) {
        char[] chars = s.toCharArray();
        int start = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || i == chars.length - 1) {
                reverse1(chars, start, i);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    public static void reverse1(char[] chars, int start, int end) {
        if (end != chars.length - 1)
            --end;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            ++start;
            --end;
        }
    }

    public static String reverseWords1(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            StringBuilder temp = new StringBuilder(string);
            temp.reverse();
            sb.append(temp).append(" ");
        }
        return sb.toString().trim();
    }
}

/*
Given a string s, reverse the order of characters in each word within a sentence while
still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/
