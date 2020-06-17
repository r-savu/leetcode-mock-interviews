/*
  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

  Example:

  MovingAverage m = new MovingAverage(3);
  m.next(1) = 1
  m.next(10) = (1 + 10) / 2
  m.next(3) = (1 + 10 + 3) / 3
  m.next(5) = (10 + 3 + 5) / 3*/

class MovingAverage {
    private Queue<Integer> q;
    private int sz;
    private int n;
    private int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sz = size;
        q = new LinkedList<Integer>();
        n = 0;
        sum = 0;
    }

    public double next(int val) {
        q.add(val);
        sum += val;
        n++;
        if (n > sz) {
            sum -= q.poll();
            n--;
        }
        return 1.0 * sum / n;
    }
}
