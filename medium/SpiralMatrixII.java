/*
  Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

  Example:

  Input: 3
  Output:
  [
    [ 1, 2, 3 ],
    [ 8, 9, 4 ],
    [ 7, 6, 5 ]
  ]*/

class Solution {
    private int[][] m;
    private int n;

    private void fill(int startNum, int layer) {
        if (Math.ceil( 1.0 * n / 2) < layer) return;
        int cur = startNum;
        int l = layer;
        for (int i = l; i < n - l; i++) {
            m[l][i] = cur++;
        }
        for (int i = l + 1; i < n - l; i++) {
            m[i][n - l - 1] = cur++;
        }
        for (int i = l + 1; i < n - l; i++) {
            m[n - l - 1][n - i - 1] = cur++;
        }
        for (int i = l + 1; i < n - l - 1; i++) {
            m[n - i - 1][l] = cur++;
        }

        fill(cur, layer + 1);
    }

    public int[][] generateMatrix(int n) {
        m = new int[n][n];
        this.n = n;
        fill(1, 0);
        return m;
    }
}
