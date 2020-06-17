/*
  In a given grid, each cell can have one of three values:

  the value 0 representing an empty cell;
  the value 1 representing a fresh orange;
  the value 2 representing a rotten orange.
  Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

  Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

  Example 1:



  Input: [[2,1,1],[1,1,0],[0,1,1]]
  Output: 4
  Example 2:

  Input: [[2,1,1],[0,1,1],[1,0,1]]
  Output: -1
  Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
  Example 3:

  Input: [[0,2]]
  Output: 0
  Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

  Note:

  1 <= grid.length <= 10
  1 <= grid[0].length <= 10
  grid[i][j] is only 0, 1, or 2.*/

class Solution {
    private int numFresh = 0;
    private int minute = -1;
    private static final int[][] DIRECTIONS =
        new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) numFresh++;
                else if (grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        if (numFresh == 0) return 0;
        q.add(null);
        int m = grid.length;
        int n = grid[0].length;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur == null) {
                minute++;
                if (q.peek() == null) break;
                q.add(null);
                continue;
            }
            for (int[] d : DIRECTIONS) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1) continue;
                grid[r][c] = 2;
                numFresh--;
                q.add(new int[]{r,c});
            }
        }

        return numFresh > 0 ? -1 : minute;
    }
}
