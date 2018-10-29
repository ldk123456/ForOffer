/**
 * 二叉搜索树的第k个结点
 */
public class KthNode {

    int index = 0; //计数器
    TreeNode KthNode(TreeNode root, int k) {
        //中序遍历寻找第k个
        if(root != null){
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}
