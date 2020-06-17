/*
  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

  Example 1:

  Input: "babad"
  Output: "bab"
  Note: "aba" is also a valid answer.
  Example 2:

  Input: "cbbd"
  Output: "bb"*/

class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        String longest = "";
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            //odd
            while (i - j >= 0 && i + j < l) {
                int c1 = s.charAt(i-j);
                int c2 = s.charAt(i+j);
                if ( c1 != c2 ) break;
                j++;
            }
            j--;
            if(1 + 2 * j > max) {
                max = 1 + 2 * j;
                longest = s.substring(i-j, i + j + 1);
            }
            j = 0;
            //even
            while (i - j >= 0 && i + j + 1 < l) {
                int c1 = s.charAt(i-j);
                int c2 = s.charAt(i+1+j);
                if ( c1 != c2 ) break;
                j++;
            }
            j--;
            if(2 + 2 * j > max) {
                max = 2 + 2 * j;
                longest = s.substring(i-j, i + j + 2);
            }
        }

        return longest;
    }
}
