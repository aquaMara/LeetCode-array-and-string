package org.aquamara;

import java.util.Arrays;

// Longest Common Prefix
// 10/13/2023
// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
public class $LongestCommonPrefix {

    public static void main(String[] args) {

        String s1 = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        String s2 = longestCommonPrefix(new String[]{"dog","racecar","car"});
        // String s3 = longestCommonPrefix(new String[]{"", "", ""});
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int i1 = strs[i].indexOf(prefix);
            while (strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        }

        return prefix;
    }

    public static String longestCommonPrefix11(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        if (first.equals("") || last.equals(""))
            return "";

        int index = 0;
        while (first.charAt(index) == last.charAt(index)) {
            ++index;

            if (index == first.length() || index == last.length())
                break;
        }

        return first.substring(0, index);
    }

    public static String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder longestCommonPrefix = new StringBuilder();
        int index = 0;
        while (first.charAt(index) == last.charAt(index)) {
            longestCommonPrefix.append(first.charAt(index));
            ++index;
            if (index == first.length() || index == last.length())
                break;
        }

        return longestCommonPrefix.toString();
    }
}

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/
