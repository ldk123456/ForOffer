import java.util.ArrayList;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class PrintListFromTailToHead {
    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        ArrayList<Integer> list=printListFromTailToHead(root);
        System.out.println(list);
    }
    // 从尾到头打印链表
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /**
         * 利用栈的先进后出特性
         */
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;

        /**
         * 先反转链表，再输出
         */
        /*ArrayList<Integer> list=new ArrayList<>();
        ListNode pre=null;
        ListNode next=null;
        while (listNode!=null){
            next=listNode.next;
            listNode.next=pre;
            pre=listNode;
            listNode=next;
        }
        while (pre!=null){
            list.add(pre.val);
            pre=pre.next;
        }
        return list;*/

    }
}
