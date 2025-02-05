/*
  Given a string, find the length of the longest substring without repeating characters.

  Example 1:

  Input: "abcabcbb"
  Output: 3 
  Explanation: The answer is "abc", with the length of 3. 
  Example 2:

  Input: "bbbbb"
  Output: 1
  Explanation: The answer is "b", with the length of 1.
  Example 3:

  Input: "pwwkew"
  Output: 3
  Explanation: The answer is "wke", with the length of 3. 
  Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;

        int i = 0;
        while (i < chars.length) {
            Set<Character> set = new HashSet<Character>();
            set.add(chars[i]);
            int j = i + 1;
            while (j < chars.length && !set.contains(chars[j])) {
                set.add(chars[j++]);
            }
            res = Math.max(res, set.size());
            i++;
        }
        return res;
    }
}
