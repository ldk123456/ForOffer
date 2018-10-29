import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 */
public class Convert {
    protected TreeNode leftLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        /**
         * 方法一：递归版
         * 解题思路：
         * 1.将左子树构造成双链表，并返回链表头节点。
         * 2.定位至左子树双链表最后一个节点。
         * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
         * 4.将右子树构造成双链表，并返回链表头节点。
         * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
         * 6.根据左子树链表是否为空确定返回的节点。
         */
        if (pRootOfTree==null)
            return null;
        if (pRootOfTree.left==null&&pRootOfTree.right==null)
            return pRootOfTree;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode p=left;
        // 2.定位至左子树双链表最后一个节点
        while (p!=null&&p.right!=null)
            p=p.right;
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left!=null){
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right=Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right!=null){
            right.left=pRootOfTree;
            pRootOfTree.right=right;
        }
        if (left!=null)
            return left;
        else
            return pRootOfTree;

        /**
         * 方法二：非递归版
         * 解题思路：
         * 1.核心是中序遍历的非递归算法。
         * 2.修改当前遍历节点与前一遍历节点的指针指向。
         */
        /*if(pRootOfTree==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;      // 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;   // 将中序遍历序列中的第一个节点记为root
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;*/

        /**
         * 方法三：改进递归版
         * 解题思路：
         * 思路与方法二中的递归版一致，仅对第2点中的定位作了修改，
         * 新增一个全局变量记录左子树的最后一个节点。
         */
        /*if(pRootOfTree==null)
            return null;
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            leftLast = pRootOfTree;// 最后的一个节点可能为最右侧的叶节点
            return pRootOfTree;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;*/
    }
}
