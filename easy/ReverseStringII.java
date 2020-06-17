/*
  Given a string and an integer k, you need to reverse the first k characters for
  every 2k characters counting from the start of the string.
  If there are less than k characters left, reverse all of them. If there are less than
  2k but greater than or equal to k characters, then reverse the first k characters
  and left the other as original.

  Example:
  Input: s = "abcdefg", k = 2
  Output: "bacdfeg"
  Restrictions:
  The string consists of lower English letters only.
  Length of the given string and k will in the range [1, 10000]*/

class Solution {
    public String reverseStr(String s, int k) {
        int slen = s.length();
        char[] buff = new char[slen];
        Stack<Character> st = new Stack<Character>();
        
        boolean rev = false;
        int j = 0;
        
        for (int i = 0; i < slen; i++) {
            if (i % k == 0) {
                rev = !rev;
                if (st.isEmpty()) j = i;
            }
            if (rev) st.push(s.charAt(i));
            else {
                while (!st.isEmpty()) {
                    buff[j++] = st.pop();
                }
                buff[i] = s.charAt(i);
            }
        }
        while (!st.isEmpty()) {
            buff[j++] = st.pop();
        }
        return new String(buff);
        
    }
}
