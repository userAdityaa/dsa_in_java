class MyStack {
    Queue<Integer> container = new LinkedList<>(); 
    public void push(int x) {
        container.add(x); 
        for(int i = 1; i < container.size(); i++) container.add(container.remove());
    }
    
    public int pop() {
        return container.remove();
    }
    
    public int top() {
        return container.peek();
    }
    
    public boolean empty() {
        return container.isEmpty();
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