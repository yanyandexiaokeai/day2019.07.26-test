class Node{
    int val;
    Node next;
}
     // 删除有序链表中重复的结点
     // 思路：定义两个引用比较
public class Review {
    public Node deleteDuplicated(Node head) {
        //为了防止链表为空要分开讨论，给它定义一个假的结点，保证都有前驱
        Node prev=new Node();
        Node fake=prev;
        prev.next=head;
        Node p=head;
        Node q=head.next;

        while(q!=null){
            if (p.val!=q.val){
                prev=p;
                p=q;
                q=q.next;
            }else{
                while(q!=null&&q.val==p.val){
                    q=q.next;
                }
                prev.next=q;
                p=q;
                if (q!=null){
                    q=q.next;
                }
            }
        }
        return fake.next;
    }
    
}
