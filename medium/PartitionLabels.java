/*
  A string S of lowercase English letters is given. We want to partition this string
  into as many parts as possible so that each letter appears in at most one part,
  and return a list of integers representing the size of these parts.

  Example 1:

  Input: S = "ababcbacadefegdehijhklij"
  Output: [9,7,8]
  Explanation:
  The partition is "ababcbaca", "defegde", "hijhklij".
  This is a partition so that each letter appears in at most one part.
  A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

  Note:

  S will have length in range [1, 500].
  S will consist of lowercase English letters ('a' to 'z') only.*/


class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> minIdx = new HashMap<>();
        Map<Character, Integer> maxIdx = new HashMap<>();
        
        for (int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            if (!maxIdx.containsKey(c)) maxIdx.put(c, i);
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!minIdx.containsKey(c)) minIdx.put(c, i);
        }
        
        List<Integer> partitions = new LinkedList<>();
        int start = 0;
        int end = 0;
        while (start < S.length()) {
            char c = S.charAt(start);
            int lastC = maxIdx.get(c);
            int j = start + 1;
            end = lastC;
            while (j <= end){
                char other = S.charAt(j);
                int otherMinPos = minIdx.get(other);
                int otherMaxPos = maxIdx.get(other);
                if (start < otherMaxPos && end > otherMinPos) {
                    end = Math.max(end, otherMaxPos);
                }
                j++;
            }
            partitions.add(end - start + 1);
            start = end + 1;
            end = start;
        }
        return partitions;
    }
}
