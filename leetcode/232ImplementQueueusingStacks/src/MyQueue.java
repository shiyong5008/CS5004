import java.util.Stack;

class MyQueue {
    Stack<Integer> stackI;
    Stack<Integer> stackO;
    int top;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackI = new Stack<>();
        stackO = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stackO.isEmpty()) {
            OtoI();
        }
        stackI.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stackI.isEmpty()) {
            ItoO();
        }
        top = stackO.peek();
        stackO.pop();
        return top;
    }

    /** Get the front element. */
    public int peek() {
        while (!stackI.isEmpty()) {
            ItoO();
        }
        top = stackO.peek();
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackI.isEmpty() && stackO.isEmpty();
    }

    public void ItoO() {
        stackO.push(stackI.pop());
    }

    public void OtoI() {
        stackI.push(stackO.pop());
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
