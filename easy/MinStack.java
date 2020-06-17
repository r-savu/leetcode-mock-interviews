/*
  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

  push(x) -- Push element x onto stack.
  pop() -- Removes the element on top of the stack.
  top() -- Get the top element.
  getMin() -- Retrieve the minimum element in the stack.
 

  Example 1:

  Input
  ["MinStack","push","push","push","getMin","pop","top","getMin"]
  [[],[-2],[0],[-3],[],[],[],[]]

  Output
  [null,null,null,null,-3,null,0,-2]

  Explanation
  MinStack minStack = new MinStack();
  minStack.push(-2);
  minStack.push(0);
  minStack.push(-3);
  minStack.getMin(); // return -3
  minStack.pop();
  minStack.top();    // return 0
  minStack.getMin(); // return -2
 

  Constraints:

  Methods pop, top and getMin operations will always be called on non-empty stacks.*/

class MinStack {
    private static class Node {
        public int val;
        public int min;
        public Node next;
        public Node(int v, int m, Node n) {
            val  = v;
            min  = m;
            next = n;
        }
    }

    private Node top;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (top == null)
            top = new Node(x, x, null);
        else
            top = new Node(x, Math.min(x, top.min), top);
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
