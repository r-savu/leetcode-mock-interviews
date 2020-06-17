/*
  You are given an array of strings words and a string chars.

  A string is good if it can be formed by characters from chars (each character can only be used once).

  Return the sum of lengths of all good strings in words.


  Example 1:

  Input: words = ["cat","bt","hat","tree"], chars = "atach"
  Output: 6
  Explanation:
  The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
  Example 2:

  Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
  Output: 10
  Explanation:
  The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


  Note:

  1 <= words.length <= 1000
  1 <= words[i].length, chars.length <= 100
  All strings contain lowercase English letters only.*/

class Solution {
    private boolean isGood(String word, String chars) {
        Map<Character, Integer> charSet = new HashMap<>();
        for(int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (!charSet.containsKey(c)) charSet.put(c, 1);
            else charSet.put(c, charSet.get(c) + 1);
        }
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!charSet.containsKey(c) || charSet.get(c) < 1)
                return false;
            else charSet.put(c, charSet.get(c) - 1);
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int sumLengths = 0;
        for (String word : words){
            if (isGood(word, chars)) sumLengths += word.length();
        }
        return sumLengths;
    }
}
