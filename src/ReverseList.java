/**
 * 反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(5);
        System.out.println(reverseList(root).val);
    }
    public static ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
