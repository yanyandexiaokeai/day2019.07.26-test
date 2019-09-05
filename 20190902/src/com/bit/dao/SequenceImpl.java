package com.bit.dao;

import com.bit.Impl.ISequence;

import java.util.Arrays;

public class SequenceImpl implements ISequence {

    private Object[] elemData;
    private int usedSize;
    public static final int DEFAULT_CAPACITY=10;

    public SequenceImpl() {
        this.elemData=new Object[DEFAULT_CAPACITY];
        this.usedSize=0;
    }
    //判满
    private boolean isFull(){
        return this.usedSize==this.elemData.length;
    }
    @Override
    public boolean add(int pos, Object data) {
        //1.判断pos的合法性，放入数据后是否会溢出
        if(pos<0||pos>this.usedSize){
            return false;
        }
        //满了进行二倍扩容
        //Arrays,.copyOf有返回值
        //System.arraycopy();无返回值，有native，所以底层代码由c/c++写的，速度快
        if(isFull()){
            this.elemData= Arrays.copyOf(this.elemData,this.elemData.length*2);
            //return false;
        }
        //2、挪数据
        for (int i = this.usedSize-1; i >=pos ; i--) {
            this.elemData[i + 1] = this.elemData[i];
        }
            this.elemData[pos]=data;
            this.usedSize++;
            //3、放入数据 usedSize++
             return true;
    }

    //判断顺序表是否为空
    private  boolean isEmpty(){
        return this.usedSize==0;
    }
    @Override
    public int search(Object key) {
        if (key==null){
            throw new UnsupportedOperationException("不支持");
        }
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i <this.usedSize ; i++) {
           //错误： if (this.elemData[i]==key) Object为引用数据类型，
            // 引用数据类型比较是否相等时使用equals()方法；
             if (this.elemData[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int search(Object key, int pos) {
        if(key==null){
            throw new UnsupportedOperationException("不支持");
        }
        if (isEmpty()) {
            return -1;
        }
        for (int i = pos; i <this.usedSize ; i++) {
            //错误： if (this.elemData[i]==key) Object为引用数据类型，
            // 引用数据类型比较是否相等时使用equals()方法；
            if (this.elemData[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if (key==null){
            throw new UnsupportedOperationException("输入有误");
        }
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elemData[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if (pos<0||pos>=this.usedSize){
            return null;
        }
        return this.elemData[pos];
    }

    @Override
    public Object remove(Object key) {
        int index=search(key);
        if (index==-1){
            return null;
        }
        //将需要删除数据保存下来
        Object oldDate=this.elemData[index];
        int i=0;
        for(i=index;i<this.usedSize-1;i++){
            this.elemData[i]=this.elemData[i+1];
        }
        this.elemData[i+1]=null;
        this.usedSize--;
        return oldDate;
    }

    //把所有等于key的都删除掉
    public void removeAllKey(Object key){
        int index=search(key);
        while(index==-1) {
            for (int i = 0; i < index; i++) {
                this.elemData[i] = this.elemData[i + 1];
            }
        }
    }


    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elemData[i]+"  ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elemData[i]=null;
        }
        this.usedSize=0;
    }
}
