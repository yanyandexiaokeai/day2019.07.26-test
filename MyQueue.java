//用栈实现队列


import java.util.ArrayList;

public class MyQueue {
    //定义两个栈
    private ArrayList<Integer> in;
    private ArrayList<Integer> out;

    public MyQueue() {
        in = new ArrayList<Integer>();
        out = new ArrayList<Integer>();
    }

    //进队列
    public void push(int x) {

        in.add(x);
    }

    //返回队首元素并删除
    public int pop() {
        if (out.isEmpty()) {
            int size = in.size();
            for (int i = 0; i < size; i++) {
                int v = in.remove(in.size() - 1);
                out.add(v);
            }
        }

        return out.remove(out.size() - 1);
    }

    //返回队首元素
    public int peek() {
        if (out.isEmpty()) {
            int size = in.size();
            for (int i = 0; i < size; i++) {
                int v = in.remove(in.size() - 1);
                out.add(v);
            }
        }

        return out.get(out.size() - 1);
    }

    public boolean empty() {

        return in.isEmpty() && out.isEmpty();
    }
}
