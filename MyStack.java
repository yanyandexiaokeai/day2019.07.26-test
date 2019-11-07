// 用队列实现栈。
import java.util.LinkedList;

class MyStack {

    //不用自己实现队列
    private LinkedList<Integer> queue;

    /** Initialize your data structure here. */
    //构造方法
    public MyStack() {

        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */

    public void push(int x) {

        queue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            //pollFirst返回第一个元素或null
            int v = queue.pollFirst();
            queue.addLast(v);
        }

        return queue.pollFirst();
    }

    /** Get the top element. */
    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int v = queue.pollFirst();
            queue.addLast(v);
        }

        int v = queue.pollFirst();
        queue.addLast(v);
        return v;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
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
