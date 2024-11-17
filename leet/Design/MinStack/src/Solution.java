import java.util.Stack;

public class Solution {
    public static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            this.stack.push(val);

            if(minStack.isEmpty() || val <= minStack.peek()){
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            this.stack.pop();
            this.minStack.pop();
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin(){
            return this.minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.pop();
        int i = minStack.top();
        int j = minStack.getMin();
    }
}
