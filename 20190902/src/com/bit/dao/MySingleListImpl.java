package com.bit.dao;

import com.bit.Impl.ILinked;

public class MySingleListImpl implements ILinked {


    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node head;

    public MySingleListImpl(){
        this.head=null;
    }
    @Override
    public void addFirst(int data) {
        //拿到node
        Node node = new Node(data);
        //第一次插入数据
        if (this.head==null){
            this.head=node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        //1.是不是第一次插入
        //2、找到尾巴
        //3、插入
        Node node=new Node(data);
        Node cur=this.head;
        if(cur==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }


    //找到index-1位置的节点
    private Node searchIndex(int index){
        checkIndex(index);
        //0
        if(index==0){
            return null;
        }
        int count=0;//记录走的步数
        Node cur=this.head;
        while(cur.next!=null&&count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }

    //检查index的合法性
    private void checkIndex(int index){
        if (index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }

    }
    @Override
    public boolean addindex(int index, int data) {
        Node node=new Node(data);
        Node cur=searchIndex(index);
        if(cur==null){
            node.next=this.head;
            this.head=node;
        }else{
            node.next=cur.next;
            cur.next=node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        while(cur!=null){
            if (cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


    private Node searchPre(int key){
        //1、是不是第一个节点if(head.data==key)
        //pre为要删除节点的前驱
        Node pre=this.head;
        if (pre.data==key){
            return this.head;
        }
        while(pre.next!=null){
            if (pre.next.data==key){
                return pre;
            }
            pre=pre.next;
        }
        return null;
        //2、if(cur.next.data==key)
    }
    @Override
    public int remove(int key) {
        //保存data的值
        int oldData=0;
        Node pre=searchPre(key);
        //没有找到
        if (pre==null){
            //return -1;
            throw new UnsupportedOperationException("没有key的前驱");
        }
        if(pre==this.head&&pre.data==key){
            oldData=this.head.data;
            this.head=this.head.next;
            return oldData;
        }
        //delNode为将要删除的值
        Node delNode=pre.next;
        pre.next=delNode.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if (cur.data==key){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        //第一个节点
        if (this.head.data==key){
            this.head=this.head.next;
        }
    }

    @Override
    //得到节点的个数
    public int getLength() {
        Node cur=this.head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head!=null){
            Node cur=this.head.next;
            this.head.next=null;
            this.head=cur;
        }
    }
}
