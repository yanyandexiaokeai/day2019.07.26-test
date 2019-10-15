// key-value 模型
public class HashBucket {
    //有链表，定义链表结点Node
    private static class Node {
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[]  array;
    private int size;   // 当前的数据个数
    //负载因子
    private static final double LOAD_FACTOR = 0.75;

    public int put(int key, int value) {
        // key => int
        // int 合法的下标
        int index = key % array.length;

        // 2. 在链表中查找 key 所在的结点
        //      如果找到了，更新
        //      所有结点都不是 key，插入一个新的结点
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (key == cur.key) {
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        size++;

        if (loadFactor() >= LOAD_FACTOR) {
            resize();
        }

        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node next;
            for (Node cur = array[i]; cur != null; cur = next) {
                next = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    private double loadFactor() {
        return size * 1.0 / array.length;
    }

    //构造方法
    public HashBucket() {
        array = new Node[8];
        size = 0;
    }

    public int get(int key) {
        // 1. key =》 int 类型
        // 2. 保证下标是合法的
        int index = key % array.length;

        Node head = array[index];
        for (Node cur = head; cur != null; cur = cur.next) {
            if (key == cur.key) {
                return cur.value;
            }
        }

        return -1;
    }
}







