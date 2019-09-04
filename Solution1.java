/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            if (cur.val==val){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        //第一个节点
        if (head.val==val){
            head=head.next;
        }
        return head;
    }
}