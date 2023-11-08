package org.aquamara;

// Implement strStr()
// 10/13/2023
// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
public class $ImplementStrStr {

    public static void main(String[] args) {
        int i5 = strStr("a","a");
        int i4 = strStr("mississippi","issip");
        int i3 = strStr("leetcode", "leeto");
        int i1 = strStr("sadbutsad", "sad");
        int i2 = strStr("haystack", "needle");
    }

    public static int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i < haystack.length() - needle.length(); i++) {

            int j = 0;
            while (haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                if (j == needle.length())
                    return i;
            }
        }

        return -1;
    }

    // ???
    public static int strStr22(String haystack, String needle) {
        int index = -1;

        if (haystack.length() < needle.length())
            return index;

        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            if (haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    if (haystack.charAt(i + j) == needle.charAt(j) && j == needle.length() - 1)
                        return index;
                }
            }
        }
        return -1;
    }
}

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/
