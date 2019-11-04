//用单链表实现队列
class Node{
    int val;
    Node next;
    Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
    Node(int val){
        this(val,null);
    }
}
public class Queue {
    private Node front = null;//链表的第一个结点
    private Node rear = null;//链表的最后一个结点
    private int size = 0;

    //尾插
    public void push(int val){
        Node node = new Node(val);
        if(front == null){
            front = node;
        }else{
            rear.next = node;
        }
        rear = node;
        size++;
    }

    //头删
    public void pop(){
        if(size <=0){
            System.out.println("对列为空");
            return;
        }
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
    }

    public int front(){
        return front.val;
    }

    public int rear(){
        return rear.val;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
