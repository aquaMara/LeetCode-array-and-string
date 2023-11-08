package org.aquamara;

// Add Binary
// 10/13/2023
// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
public class $AddBinary {

    public static void main(String[] args) {
        String s14 = addBinary("0", "0");
        String s2 = addBinary("1010", "1011");
        String s12 = addBinary("10", "1");
        String s13 = addBinary("10", "0");
        String s1 = addBinary("11", "1");
        String s11 = addBinary("111", "11");
    }

    public static String addBinary(String a, String b) {

        StringBuilder sum = new StringBuilder();

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int temp = 0, remainder = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            temp = remainder;
            temp += aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
            temp += bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;

            sum.append(temp % 2);
            remainder = temp / 2;
            --aIndex;
            --bIndex;
        }

        if (remainder != 0)
            sum.append(remainder);

        return sum.reverse().toString();
    }

    public static String addBinary11(String a, String b) {

        if (a.equals(b) && a.equals("0"))
            return a;

        long aNumber = Long.parseLong(a);
        long bNumber = Long.parseLong(b);
        long remainder = 0;

        StringBuilder sum = new StringBuilder();
        long temp = 0;

        while (aNumber != 0 || bNumber != 0) {
            temp = aNumber % 10 + bNumber % 10 + remainder;

            remainder = temp >= 2 ? 1 : 0;
            temp = temp % 2 == 0 ? 0 : 1;

            sum.append(temp);
            aNumber /= 10;
            bNumber /= 10;
        }
        if (remainder == 1)
            sum.append(remainder);

        return sum.reverse().toString();
    }

    public static String addBinary1(String a, String b) {

        int aNumber = Integer.parseInt(a);
        int bNumber = Integer.parseInt(b);
        int remainder = 0;

        StringBuilder sum = new StringBuilder("");
        int temp = 0;

        while (aNumber != 0 || bNumber != 0) {
            temp = aNumber % 10 + bNumber % 10 + remainder;
            if (temp == 2) {
                temp = 0;
                remainder = 1;
            } else if (temp == 3) {
                temp = 1;
                remainder = 1;
            } else {
                remainder = 0;
            }
            sum.append(temp);
            aNumber /= 10;
            bNumber /= 10;
        }
        if (remainder == 1)
            sum.append(remainder);

        return sum.reverse().toString();
    }
}

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/
