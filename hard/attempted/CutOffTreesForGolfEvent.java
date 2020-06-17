/*
  You are asked to cut off trees in a forest for a golf event.
  The forest is represented as a non-negative 2D map, in this map:

  0 represents the obstacle can't be reached.
  1 represents the ground can be walked through.
  The place with number bigger than 1 represents a tree can be walked through,
  and this positive number represents the tree's height.
  In one step you can walk in any of the four directions top, bottom,
  left and right also when standing in a point which is a tree you can decide
  whether or not to cut off the tree.
  
  You are asked to cut off all the trees in this forest in the order of tree's
  height - always cut off the tree with lowest height first. And after cutting,
  the original place has the tree will become a grass (value 1).
  
  You will start from the point (0, 0) and you should output the minimum steps
  you need to walk to cut off all the trees. If you can't cut off all the trees,
  output -1 in that situation.
  
  You are guaranteed that no two trees have the same height and there is at least
  one tree needs to be cut off.
  
  Example 1:
  
  Input: 
  [
   [1,2,3],
   [0,0,4],
   [7,6,5]
  ]
  Output: 6
  
  Example 2:
  
  Input: 
  [
   [1,2,3],
   [0,0,0],
   [7,6,5]
  ]
  Output: -1
  
  Example 3:
  
  Input: 
  [
   [2,3,4],
   [0,0,5],
   [8,7,6]
  ]
  Output: 6
  Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
  
  Constraints:
  
  1 <= forest.length <= 50
  1 <= forest[i].length <= 50
  0 <= forest[i][j] <= 10^9*/

class Solution {
    private static final int[][] DIRECTIONS = 
        new int[][]{{0, 1}, {0, -1}, {1,0}, {-1,0}};
    
    private int m;
    private int n;
    private int[][] board;
    private boolean[][] visited;
    private int[] pos;
    
    private int bfs(int t){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(pos);
        q.add(null);
        int walk = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();       
            if (cur != null) {
                int r = cur[0];
                int c = cur[1];
                visited[r][c] = true;
                if (board[r][c] == t) {
                    pos[0] = r;
                    pos[1] = c;
                    return walk;
                }
                for(int[] d : DIRECTIONS){
                    int rr = r + d[0];
                    int cc = c + d[1];
                    if (rr < 0 || cc < 0 || rr >= m || cc >= n 
                        || board[rr][cc] == 0 || visited[rr][cc]) 
                        continue;
                    q.add(new int[]{rr, cc});
                }
                
            } else {
                if (q.peek() == null) return -1;
                q.add(null);
                walk++;
            }
        }
        
        return -1;
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        board = new int[m][n];
        visited = new boolean[m][n];
        
        ArrayList<Integer> treeList = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tree = forest.get(i).get(j);
                board[i][j] = tree;
                if (tree > 1) treeList.add(tree);
            }
        }
        
        pos = new int[]{0,0};
        Collections.sort(treeList);
        int walk = 0;
        for (int t : treeList) {
            int w = bfs(t);
            if (w == -1) return -1;
            walk += w;
        }
        return walk;
    }
}
