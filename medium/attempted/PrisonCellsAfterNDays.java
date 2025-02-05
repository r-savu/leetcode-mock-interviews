/*
  There are 8 prison cells in a row, and each cell is
  either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant,
then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells
in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way:
cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N
days (and N such changes described above.)


Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
*/

class Solution {
    private Map<String, int[]> memo= new HashMap<>();;

    private String key(int[] cells, int N) {
        String s = "";
        for(int c : cells) {
            s += c;
        }
        s += N % ((int)Math.pow(2, 8));
        return s;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        String k = key(cells, N);
        if (memo.containsKey(k)) return memo.get(k);

        int[] next = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            if (i == 0 || i == cells.length - 1) next[i] = 0;
            else {
                next[i] = 1 - ((cells[i-1] + cells[i+1]) % 2);
            }
        }
        memo.put(key(next, N), next);
        if (N < 2) return next;
        return prisonAfterNDays(next, N - 1);

    }
}
