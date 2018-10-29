/**
 * 链表中环的入口结点
 */
public class EntryNodeOfLoop {
    /**
     * 双指针法
     * 设置快慢两个指针，慢指针一次走一步，快指针一次走两步
     * 如果两指针相遇，说明有环，否则没有环
     * 任何把其中一个指针指向表头，两个指针但每次都走一步
     * 相遇点即为环的入口
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null || pHead.next==null || pHead.next.next==null)
            return null;
        ListNode slow=pHead.next;
        ListNode fast=pHead.next.next;
        while (slow!=fast){
            if(fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else
                return null;
        }
        slow=pHead;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
