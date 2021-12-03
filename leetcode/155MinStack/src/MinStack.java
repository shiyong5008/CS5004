/*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class MinStack {
    Stack<Integer> stk;
    int min;
    List<Integer> list;
    Object[] a;

    public MinStack() {
        stk = new Stack<>();
        min = Integer.MIN_VALUE;
        list = new ArrayList<>();

    }

    public void push(int val) {
        stk.push(val);
        list.add(val);
        a = list.toArray();
        Arrays.sort(a);

    }

    public void pop() {
        stk.pop();
        list.remove(list.size()-1);
        a = list.toArray();
        Arrays.sort(a);

    }

    public int top() {
        return stk.peek();

    }

    public int getMin() {
        return (int) a[0];

        }
}


 */


import java.util.Stack;

class MinStack {
    Stack<Integer> stk;
    Stack<Integer> stkMin;

    public MinStack() {
        stk = new Stack<>();
        stkMin = new Stack<>();
        stkMin.push(Integer.MAX_VALUE);

    }

    public void push(int val) {
        stk.push(val);
        if (val < stkMin.peek()) {
            stkMin.push(val);
        } else {
            stkMin.push(stkMin.peek());
        }

    }

    public void pop() {
        stk.pop();
        stkMin.pop();

    }

    public int top() {
        return stk.peek();

    }

    public int getMin() {
        return stkMin.peek();

    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
