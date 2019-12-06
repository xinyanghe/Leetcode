class MyStack {
    public Queue<Integer> q1 = new LinkedList<Integer>();
    public Queue<Integer> q2 = new LinkedList<Integer>();
    
    private void move() {
        while(q1.size() != 1) {
            q2.offer(q1.poll());
        }
    }
    
    private void swap() {
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        move();
        int pop = q1.poll();
        swap();
        return pop;
    }
    
    /** Get the top element. */
    public int top() {
        move();
        int top = q1.poll();
        swap();
        q1.offer(top);
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
