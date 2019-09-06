//链表逆置
class Node{
    int value;
    Node next;
}
public class Main {
    public static Node reverse(Node head){
        //遍历，把每个结点头插到新链表中
        //指向新链表的第一个结点
        Node result=null;
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            //把cur头插到新链表中
            cur.next=result;
            result=cur;
            //cur=cur.next;
            cur=next;
        }
        return result;
    }

// 合并有序链表
    /*
    思路：遍历两个链表中的结点，进行结点值的比较，然后将值小的结点尾插到新链表上，再把剩余的链表接到新链表后面

    尾插：分情况讨论：1、如果链表为空的情况  2、链表不为空
     */
    public static Node merge(Node head1,Node head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        //遍历其中一个链表，让其尾插进另一个链表
        Node cur1=head1;
        Node cur2=head2;
        Node result=null;//给一个空的链表
        Node last=null;//记录

        while(cur1!=null&&cur2!=null){
            if (cur1.value<=cur2.value){
                if (result==null){
                    result=cur1;
                }else{
                    last.next=cur1;
                }
                last=cur1;
                cur1=cur1.next;
            }else{
                if (result==null){
                    result=cur2;
                }else{
                    last.next=cur2;
                }
                last=cur2;

                cur2=cur2.next;
            }
        }
        if (cur1!=null){
            last.next=cur1;
        }else{
            last.next=cur2;
        }
        return result;
    }

    //合并有序链表的优化版
    public static Node merge2(Node head1,Node head2){
        //为了防止链表为空，先新建一个结点
        Node result =new Node();
        Node last =result;

        Node cur1=head1;
        Node cur2=head2;

        while (cur1!=null&&cur2!=null){
            if (cur1.value<=cur2.value){
                last.next=cur1;
                cur1=cur1.next;
            }else{
                last.next=cur2;
                cur2=cur2.next;
            }
            last=last.next;
        }
        if (cur1!=null){
            last.next=cur1;
        }else{
            last.next=cur2;
        }
        //第一个结点是自己定义的，所以取下一个值
        return result.next;
    }
}
