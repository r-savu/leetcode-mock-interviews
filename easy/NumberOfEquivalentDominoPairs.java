/*
  Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
  if and only if either (a==c and b==d), or (a==d and b==c) - that is,
  one domino can be rotated to be equal to another domino.

  Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length,
  and dominoes[i] is equivalent to dominoes[j].

  Example 1:

  Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
  Output: 1


  Constraints:

  1 <= dominoes.length <= 40000
  1 <= dominoes[i][j] <= 9*/

class Solution {
    private Map<String, Integer> doms = new HashMap<>();
    
    private String key(int[] piece) {
        return piece[0] < piece[1] 
            ? piece[0] + " " + piece[1]
            : piece[1] + " " + piece[0];
    }
    
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] piece : dominoes) {
            String k = key(piece);
            if (doms.containsKey(k)) doms.put(k, doms.get(k) + 1);
            else doms.put(k, 1);
        }
        
        int numPairs = 0;
        
        for (int pile : doms.values()) {
            if (pile > 1) {
                numPairs += (pile * (pile - 1)) / 2;
            }
        }
        return numPairs;
    }
}
