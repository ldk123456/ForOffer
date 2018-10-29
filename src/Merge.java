public class Merge {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(4);
        ListNode listNode2=new ListNode(2);
        listNode2.next=new ListNode(3);
        ListNode node=merge(listNode1, listNode2);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public static ListNode merge(ListNode list1,ListNode list2) {
        //非递归
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode result=new ListNode(0);
        ListNode head=result;
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                result.next=list1;
                list1=list1.next;
                result=result.next;
            }else {
                result.next=list2;
                list2=list2.next;
                result=result.next;
            }
        }
        if (list1==null){
            result.next=list2;
        }
        if (list2==null){
            result.next=list1;
        }
        return head.next;

        //递归
        /*if (list1==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next =merge(list1.next, list2);
            return list1;
        }else

        {
            list2.next = merge(list1, list2.next);
            return list2;
        }*/
    }
}
