package com.bit.main;

import com.bit.dao.MySingleListImpl;
import com.bit.dao.SequenceImpl;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        MySingleListImpl mySingleList=new MySingleListImpl();
        mySingleList.addFirst(18);
        mySingleList.addFirst(18);
        mySingleList.addFirst(99);
        mySingleList.display();
        mySingleList.addindex(0,18);
        mySingleList.addLast(100);
        mySingleList.display();
        System.out.println(mySingleList.contains(78));
        mySingleList.remove(99);
        mySingleList.display();
        mySingleList.remove(18);
        mySingleList.display();
        mySingleList.removeAllKey(18);
        mySingleList.display();
        mySingleList.clear();
        Thread.sleep(1000);
        System.out.println("睡醒了");

    }
    public static void main1(String[] args) {
        SequenceImpl sequence=new SequenceImpl();
        for (int i = 0; i < 10; i++) {
            sequence.add(i,i);
        }
        sequence.display();
        sequence.add(10,"bit");
        sequence.display();
        sequence.add(11,"java");
        sequence.display();
        sequence.remove("bit");
        sequence.display();
        System.out.println("=========");
        sequence.clear();
        sequence.display();
    }
}
