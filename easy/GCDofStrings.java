/*
  For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

  Return the largest string X such that X divides str1 and X divides str2.

  Example 1:
  Input: str1 = "ABCABC", str2 = "ABC"
  Output: "ABC"

  Example 2:
  Input: str1 = "ABABAB", str2 = "ABAB"
  Output: "AB"

  Example 3:
  Input: str1 = "LEET", str2 = "CODE"
  Output: ""


  Note:

  1 <= str1.length <= 1000
  1 <= str2.length <= 1000
  str1[i] and str2[i] are English uppercase letters.*/


class Solution {
    private String helper(String l, String s) {
        int ll = l.length();
        int sl = s.length();
        if (l.compareTo(s) == 0) return l;
        else if (ll == sl) return "";
        else {
            int start;
            for (start = 0; start < ll - sl; start += sl) {
                if (l.substring(start, start + sl).compareTo(s) != 0) {
                    return "";
                }
            }
            return helper(s, l.substring(start));
        }
    }

    public String gcdOfStrings(String str1, String str2) {
        String small = str1.length() > str2.length() ? str2 : str1;
        String large = str1.length() > str2.length() ? str1 : str2;

        return helper(large, small);
    }
}
