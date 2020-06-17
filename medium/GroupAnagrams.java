/*
  Given an array of strings, group anagrams together.

  Example:

  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  Output:
  [
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
  ]
  Note:

  All inputs will be in lowercase.
  The order of your output does not matter.*/

class Solution {
    // O(l)
    private boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (m.containsKey(c1)) {
                m.put(c1, m.get(c1) + 1);
            } else {
                m.put(c1, 1);
            }

            if (m.containsKey(c2)) {
                m.put(c2, m.get(c2) - 1);
            } else {
                m.put(c2, -1);
            }
        }
        for(int i: m.values()) {
            if (i != 0) return false;
        }
        return true;
    }

    //O(l log l)
    private String buildKey(String s1) {
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            String key = buildKey(cur);
            if (m.containsKey(key)) {
                m.get(key).add(cur);
            } else {
                List<String> list = new LinkedList<String>();
                list.add(cur);
                m.put(key, list);
            }
        }

        List<List<String>> out = new LinkedList<List<String>>();
        for (String k : m.keySet()) {
            out.add(m.get(k));
        }
        return out;
    }
}
