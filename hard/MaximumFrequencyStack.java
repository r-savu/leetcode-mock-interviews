/*
  Implement FreqStack, a class which simulates the operation of a stack-like data structure.

  FreqStack has two functions:

  push(int x), which pushes an integer x onto the stack.
  pop(), which removes and returns the most frequent element in the stack.
  If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.


  Example 1:

  Input:
  ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
  [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
  Output: [null,null,null,null,null,null,null,5,7,5,4]
  Explanation:
  After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

  pop() -> returns 5, as 5 is the most frequent.
  The stack becomes [5,7,5,7,4].

  pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
  The stack becomes [5,7,5,4].

  pop() -> returns 5.
  The stack becomes [5,7,4].

  pop() -> returns 4.
  The stack becomes [5,7].


  Note:

  Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
  It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
  The total number of FreqStack.push calls will not exceed 10000 in a single test case.
  The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
  The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
*/

class FreqStack {
    private Map<Integer, Stack<Integer>> insMap;
    private Map<Integer, Integer> freqMap;
    private int maxFreq = 0;

    public FreqStack() {
        freqMap = new HashMap<Integer, Integer>();
        insMap = new HashMap<Integer, Stack<Integer>>();
    }

    public void push(int x) {
        int freq = freqMap.containsKey(x) ? freqMap.get(x) + 1 : 1;
        if (freq > maxFreq) maxFreq = freq;
        freqMap.put(x, freq);

        if (!insMap.containsKey(freq)) insMap.put(freq, new Stack<Integer>());

        insMap.get(freq).push(x);
    }

    public int pop() {
        Stack<Integer> bigStack = insMap.get(maxFreq);
        int elem = bigStack.pop();
        freqMap.put(elem, maxFreq - 1);
        if (bigStack.isEmpty()) maxFreq--;
        return elem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
