/*
  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

  Examples:

  s = "leetcode"
  return 0.

  s = "loveleetcode",
  return 2.
 

  Note: You may assume the string contain only lowercase English letters.*/

class Solution {
    public int firstUniqChar(String s) {
        Set<Character> chars = new HashSet<Character>();
        Set<Character> dupes = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.contains(c)) chars.add(c);
            else dupes.add(c);
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!dupes.contains(c)) return i;
        }
        return -1;
    }
}
