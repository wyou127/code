package code;

import java.util.*;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.


 * Created: 4/1/15 10:11 AM
 * Author: <A HREF="mailto:wyou@walmartlabs.com">Wei You</A>
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int localMin;

    public MinStack() {
        stack = new Stack<Integer> ();
        minStack = new Stack<Integer>();
        localMin = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        if (x<localMin) {
            minStack.push(x);
        }
    }

    public void pop() {
        int top = stack.peek();
        int min = minStack.peek();

        stack.pop();
        if (min == top) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }

}
