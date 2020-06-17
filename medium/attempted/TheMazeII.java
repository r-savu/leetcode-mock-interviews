/*
  There is a ball in a maze with empty spaces and walls.
  The ball can go through empty spaces by rolling up, down, left or right,
  but it won't stop rolling until hitting a wall. When the ball stops,
  it could choose the next direction.

  Given the ball's start position, the destination and the maze,
  find the shortest distance for the ball to stop at the destination.
  The distance is defined by the number of empty spaces traveled by the ball
  from the start position (excluded) to the destination (included).
  If the ball cannot stop at the destination, return -1.
  
  The maze is represented by a binary 2D array.
  1 means the wall and 0 means the empty space.
  You may assume that the borders of the maze are all walls.
  The start and destination coordinates are represented by row and column indexes.
  
  Example 1:
  
  Input 1: a maze represented by a 2D array
  
  0 0 1 0 0
  0 0 0 0 0
  0 0 0 1 0
  1 1 0 1 1
  0 0 0 0 0
  
  Input 2: start coordinate (rowStart, colStart) = (0, 4)
  Input 3: destination coordinate (rowDest, colDest) = (4, 4)
  
  Output: 12
  
  Explanation:
  One shortest way is :
  left -> down -> left -> down -> right -> down -> right.
  The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
  
  Example 2:
  
  Input 1: a maze represented by a 2D array
  
  0 0 1 0 0
  0 0 0 0 0
  0 0 0 1 0
  1 1 0 1 1
  0 0 0 0 0
  
  Input 2: start coordinate (rowStart, colStart) = (0, 4)
  Input 3: destination coordinate (rowDest, colDest) = (3, 2)
  
  Output: -1
  
  Explanation: There is no way for the ball to stop at the destination.
  
   
  
  Note:
  
  There is only one ball and one destination in the maze.
  
  Both the ball and the destination exist on an empty space,
  and they will not be at the same position initially.
  
  The given maze does not contain border
  (like the red rectangle in the example pictures), but you could assume
  the border of the maze are all walls.
  
  The maze contains at least 2 empty spaces,
  and both the width and height of the maze won't exceed 100.
  */

class Solution {
    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static final int VISITED = 2;
    
    private static final int[] UP = new int[]{-1,  0};
    private static final int[] DOWN = new int[]{ 1,  0};
    private static final int[] LEFT = new int[]{ 0, -1};
    private static final int[] RIGHT = new int[]{ 0,  1};
    
    private static final int[][] DIRECTIONS = new int[][] { UP, DOWN, LEFT, RIGHT };
    
    private static class State {
        int x;
        int y;
        int[] dir;
        int dist;
    }
    
    private boolean collision(int[][] maze, State state) {
        int m = maze.length;
        int n = maze[0].length;
        
        int x = state.x + state.dir[0];
        int y = state.y + state.dir[1];
        
        if (x < 0 || y < 0 || x >= m || y >= n || maze[x][y] == WALL)
            return true;
        return false;
    }
    
    private List<State> moves(int[][] maze, State state, boolean col) {
        List<State> moves = new LinkedList<State>();
        int m = maze.length;
        int n = maze[0].length;
        if (col) {
            for (int[] d : DIRECTIONS) {
                int x = state.x + d[0];
                int y = state.y + d[1];
                if (x > 0 && y > 0 && x < m && y < n && maze[x][y] == EMPTY) {
                    State next = new State();
                    next.x = state.x + d[0];
                    next.y = state.y + d[1];
                    next.dir = d;
                    next.dist = state.dist + 1;
                    moves.add(next);
                } 
            }
        } else {
            State next = new State();
            next.x = state.x + state.dir[0];
            next.y = state.y + state.dir[1];
            next.dir = state.dir;
            next.dist = state.dist + 1;
            moves.add(next);
        }
        
        return moves;
    }
    
   
    
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) return 0;
        Queue<State> q = new LinkedList<State>();
        State startState = new State();
        startState.x = start[0];
        startState.y = start[1];
        startState.dist = 0;
        for(State m : moves(maze, startState, true)) {
            q.add(m);
        }
        maze[startState.x][startState.y] = VISITED;
        
        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return cur.dist;
            }
            
            boolean col = collision(maze, cur);
            if (col) maze[cur.x][cur.y] = VISITED;
            for (State next : moves(maze, cur, col)) {
                q.add(next);
            }
            
        }
        return -1;
    }
}
