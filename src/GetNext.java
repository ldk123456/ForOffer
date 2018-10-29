/**
 * 二叉树的下一个结点
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null)
            return null;
        if (pNode.right!=null){         //如果有右子树，则找右子树的最左节点
            TreeLinkNode node=pNode.right;
            while (node.left!=null)
                node=node.left;
            return node;
        }

        while(pNode.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left==pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}
