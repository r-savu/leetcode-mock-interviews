/*
  Given a non-negative integer num represented as a string,
  remove k digits from the number so that the new number is the smallest possible.

  Note:
  The length of num is less than 10002 and will be ≥ k.
  The given num does not contain any leading zero.
  Example 1:

  Input: num = "1432219", k = 3
  Output: "1219"
  Explanation: Remove the three digits 4, 3, and 2 to form the new number
  1219 which is the smallest.
  Example 2:

  Input: num = "10200", k = 1
  Output: "200"
  Explanation: Remove the leading 1 and the number is 200. Note that the output
  must not contain leading zeroes.
  Example 3:

  Input: num = "10", k = 2
  Output: "0"
  Explanation: Remove all the digits from the number and it is left with
  nothing which is 0.
*/

class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        String prefix = "";
        
        while (k > 0 && num.length() > 0) {
            while ('0' == num.charAt(0) ) num = num.substring(1);
            int minDigit;
            int minIdx;
            minIdx = 0;
            minDigit = Character.getNumericValue(num.charAt(0));
            
            for(int i = 0; i < k + 1; i++) {
                int digit = Character.getNumericValue(num.charAt(i));
                if (minDigit >= digit) {
                    minIdx = i;
                    minDigit = digit;
                }
            }
            if (minIdx == 0) {
                prefix = prefix + num.charAt(0);
                num = num.substring(1);
            } else {
                num = num.substring(minIdx);
                k = k - minIdx;
            }
            
        }
        
        return prefix + num;
    }
}
