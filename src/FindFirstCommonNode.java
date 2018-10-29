import java.util.HashMap;
import java.util.Map;

/**
 * 两个链表的第一个公共结点
 */
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        /**
         * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
         * （因为2个链表用公共的尾部）
         */
        /*if (pHead1==null || pHead2==null)
            return null;
        ListNode head1=pHead1;
        ListNode head2=pHead2;
        int len1=0;
        int len2=0;
        while (head1!=null){
            head1=head1.next;
            len1++;
        }
        while (head2!=null){
            head2=head2.next;
            len2++;
        }
        if (len1<=len2){
            int len=len2-len1;
            while (len!=0){
                pHead2=pHead2.next;
                len--;
            }
        }else{
            int len=len1-len2;
            while (len!=0){
                pHead1=pHead1.next;
                len--;
            }
        }
        while (pHead1!=pHead2){
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return pHead1;*/

        /**
         * 利用HashMap
         */
        Map<ListNode, Integer> map=new HashMap<>();
        while (pHead1!=null){
            map.put(pHead1, 1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            if (map.containsKey(pHead2))
                return pHead2;
            pHead2=pHead2.next;
        }
        return null;
    }
}
