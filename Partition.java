import java.util.*;
//链表分割：编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode result = null;
        ListNode result1 = null;
        ListNode last = null;
        ListNode last1 = null;

        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                if (result == null) {
                    result = cur;
                } else {
                    last.next = cur;
                }
                last = cur;
                cur = cur.next;
            } else {
                if (result1 == null) {
                    result1 = cur;
                } else {
                    last1.next = cur;
                }
                last1 = cur;
                cur = cur.next;
            }
        }

        if(last == null){
            last1.next = null;
            return result1;
        }
        if(last1 == null){
            last.next = null;
            return result;
        }
        if(last == null&&last1 ==null){
            return null;
        }
        if(last != null && last1 != null){
            last1.next = null;
            last.next = result1;
        }
        return result;
    }
}