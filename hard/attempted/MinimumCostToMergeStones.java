/*
  There are N piles of stones arranged in a row.
  The i-th pile has stones[i] stones.

  A move consists of merging exactly K consecutive piles into one pile,
  and the cost of this move is equal to the total number of stones
  in these K piles.

  Find the minimum cost to merge all piles of stones into one pile.
  If it is impossible, return -1.


  Example 1:

  Input: stones = [3,2,4,1], K = 2
  Output: 20
  Explanation:
  We start with [3, 2, 4, 1].
  We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
  We merge [4, 1] for a cost of 5, and we are left with [5, 5].
  We merge [5, 5] for a cost of 10, and we are left with [10].
  The total cost was 20, and this is the minimum possible.

  Example 2:

  Input: stones = [3,2,4,1], K = 3
  Output: -1
  Explanation: After any merge operation, there are 2 piles left, and we can't
  merge anymore.  So the task is impossible.

  Example 3:

  Input: stones = [3,5,1,2,6], K = 3
  Output: 25
  Explanation:
  We start with [3, 5, 1, 2, 6].
  We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
  We merge [3, 8, 6] for a cost of 17, and we are left with [17].
  The total cost was 25, and this is the minimum possible.
*/

class Solution {
    private int cost;
    
    private int[] move(int[] stones, int K) {
        int minCost = Integer.MAX_VALUE; 
        int minCostIdx = 0;
        
        for (int i = 0; i < stones.length - K; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += stones[i+j];
            }
            if (sum < minCost) {
                minCost = sum;
                minCostIdx = i;
            }
        }
        
        int res[] = new int[stones.length - K + 1];
        
        for (int i = 0; i < res.length; i++) {
            if (i < minCostIdx) {
                res[i] = stones[i];
            } else if (i == minCostIdx) {
                res[i] = minCost;
            } else {
                res[i] = stones[i + K - 1];
            }
        }
        cost += minCost;
        return res;
        
        
    }
    
    public int mergeStones(int[] stones, int K) {
        if ((stones.length - 1) % (K - 1) != 0) return -1;
        cost = 0;
        
        for (int i = 0; i < (stones.length - 1) / (K - 1); i++) {
            stones = move(stones, K);
        }
        return cost;
    }
}
