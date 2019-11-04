import java.util.Arrays;

import static java.util.Arrays.copyOf;

//用顺序表实现的栈：时间复杂度：O（1）
public class Stack {
    //属性

    private int[] array;
    private int top;

    //构造方法
    public Stack(int defaultCapacity) {
        array = new int[defaultCapacity];
        top = 0;
    }
    public Stack(){
        this(20);
    }

    //插入
    public void push(int val){
        //扩容
        if(top == array.length) array = copyOf(array, array.length * 2);
        array[top++] = val;
    }
    //删除
    public void pop(){
        if(top <= 0){
            System.out.println("栈为空，无法删除");
            return;
        }
        top--;
        array[top] = 0;//可加可不加，把所有空的位置保持为0
    }

    //返回当前栈顶元素
    public int top(){
        if(top <= 0){
            System.out.println("栈为空，无法返回栈顶元素");
            return -1;
        }
        return array[top-1];
    }
    //返回栈中元素个数
    public int size(){
        return top;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top == 0;
    }
}
