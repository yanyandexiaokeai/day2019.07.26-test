//链表的插入删除（头尾）打印

//前驱 prev previous
//后继 next
class Node{//盒子
    int val;//盒子左面的值value/element
    Node next;//盒子的右面：结点的后继(存着下一个引用）
    //如果next == null;表示node是最后一个节点

    //写构造方法，将val传进去：节省时间，不用每次都写
    Node (int val){
        this.val = val;
        this.next = null;
    }

    //打印
    public String toString() {

        return String.format("Node(%d)", val);
    }
}

public class MyLinkedList {
    public static void main(String[] args) {
        Node head = null;
        //head（是一个引用）表示链表第一个节点，通过第一个结点，
        // 就可以找到完整的链表，
        // 所以链表的第一个结点往往代表整个链表
        //空的链表就是一个节点都没有的链表
        //也就没有第一个结点
        //也就是head = null表示第一个结点不存在
        // 表示整个链表为空

        //头插(空链表）
        /*
        int val = 0;
        //1、结点
        Node node =new Node(val);
        //2、让原来的head成为node的下一个结点
        node.next = head;
        //3、更新
        head = node;
        */
        head = pushFront(head, 0);
        head = pushFront(head, 1);
        head = pushFront(head, 2);

        //打印
        print(head);

        //尾删
        head = popFront(head);
        print(head);	// 1 0

        head = pushBack(head, 10);
        head = pushBack(head, 20);
        head = pushBack(head, 30);
        print(head);	// 1 0 10 20 30
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);

        head = popBack(head);	// 报错
        print(head);		// 空

        head = pushBack(head, 100);
        print(head);		// 100

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node pos = head.next.next;
        pushAfter(pos, 100);

        // 1, 2, 3, 100, 4
    }

    //在pos位置后插入val
    private static void pushAfter (Node pos,int val){
        Node node = new Node(val);

        node.next = pos.next;
        pos.next = node;
    }

    //删除指定位置pos后的值
    private static void popAfter (Node pos){

        pos.next = pos.next.next;
    }

    // 打印
    private static void print(Node head) {
        System.out.println("打印链表：");
        Node cur = head;
        while (cur != null){
            System.out.print(cur + " --> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    // 头插
    // head: 原来的第一个结点
    // val：要插入的值
    // 返回：新的第一个结点
    private static Node pushFront(Node head, int val) {
        // 1. 结点
        Node node = new Node(val);
        // 2. 让原来的 head 成为 node 的下一个结点
        node.next = head;
        // 3. 更新第一个结点的引用
        return node;
    }

    //尾插
    private static Node pushBack(Node head, int val) {
        //一、空链表
        //让新的结点成为第一个结点
        //二、非空链表
        //1、如果没在结点中，装到结点里
        //2、让新结点的next = null   构造方法中已经让.next = null了
        //3、找到倒数第一个结点（子问题），找到.next==null的结点
        //4、让原来的倒数第一个结点的下一个为新结点
        Node node = new Node(val);
        if (head == null) {
            return node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;

            return head;
        }
    }
        //头删
        private static Node popFront(Node head) {
            if (head == null) {
                System.err.println("空链表无法删除");
                return null;
            }

            // 原来第一个结点，会因为没有引用指向而被回收
            return head.next;
        }

        //尾删
        private static Node popBack(Node head) {
            if (head == null) {
                System.err.println("空链表无法删除");
                return null;
            }

            //1、找到倒数第二个结点，
            // 让倒数第二个结点的next = null
            // 原来的最后一个结点因为没有引用指向而被回收
            //只有一个结点，直接置空
            if (head.next == null) {
                return null;
            } else {
                Node lastSecond = head;
                while (lastSecond.next.next != null) {
                    lastSecond = lastSecond.next;
                }

                lastSecond.next = null;
                return head;
            }

        }
}
