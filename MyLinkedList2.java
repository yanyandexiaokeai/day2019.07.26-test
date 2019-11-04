//双向不循环不带头单链表
class Node {
    int val;
    Node next = null;   // 指向后继结点，最后一个结点的 next == null
    Node prev = null;   // 指向前驱结点，第一个结点的 prev == null

    Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList2 {
    private Node head = null;
    private Node last = null;
    private int size = 0;

    public void pushFront(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        } else {
            last = node;
        }
        head = node;

        size++;
    }

    public void popFront() {
        if (size <= 0) {
            System.out.println("无法对空链表做删除");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            last = null;
        }
        size--;
    }

    void pushBack(int val) {
        Node node = new Node(val);
        if (last == null) {
            head = node;
        } else {
            last.next = node;
        }
        node.prev = last;
        last = node;

        size++;
    }

    void popBack() {
        if (size <= 0) {
            System.out.println("无法对空链表做删除");
            return;
        }

        if (last == head) {
            head = last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }

        size--;
    }

    public void add(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("下标错误");
            return;
        }
        if (index == 0) {
            pushFront(val);
        } else if (index == size) {
            pushBack(val);
        } else {
            Node pos = getNode(index);
            Node node = new Node(val);
            node.prev = pos.prev;
            node.next = pos;
            node.prev.next = node;
            node.next.prev = node;

            size++;
        }
    }

    public void remove(int index) {
        if (size <= 0) {
            System.out.println("无法对空链表做删除");
            return;
        }

        if (index < 0 || index >= size) {
            System.out.println("下标错误");
            return;
        }

        if (index == 0) {
            popFront();
        } else if (index == size - 1) {
            popBack();
        } else {
            Node pos = getNode(index);
            pos.prev.next = pos.next;
            pos.next.prev = pos.prev;
            size--;
        }
    }

    // 代码的复用性
    private Node getNode(int index) {
        // 不需要校验 index 的合法性
        // 因为使用者 add 和 remove 已经做过类似工作了
        int backwardIndex = size - index - 1;
        Node pos;
        if (index <= backwardIndex) {
            pos = head;
            for (int i = 0; i < index; i++) {
                pos = pos.next;
            }
        } else {
            pos = last;
            for (int i = 0; i < backwardIndex; i++) {
                pos = pos.prev;
            }
        }

        return pos;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reset() {
        head = last = null;
        size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        System.out.println("3 2 1");
        list.popFront();
        list.popFront();
        list.popFront();
        System.out.println("");
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        System.out.println("10 20 30");
        list.popBack();
        list.popBack();
        list.popBack();
        System.out.println("");
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        System.out.println("1 2 3 4 5");
        list.add(1, 10);
        System.out.println("1 10 2 3 4 5");
        list.add(5, 20);
        System.out.println("1 10 2 3 4 20 5");
        list.remove(1);
        System.out.println("1 2 3 4 20 5");
        list.remove(4);
        System.out.println("1 2 3 4 5");
    }
}
