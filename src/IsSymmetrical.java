/**
 * 对称的二叉树
 */
public class IsSymmetrical {
    /**
     * 思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可，采用递归
     *
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;

        return f(pRoot.left,pRoot.right);
    }

    boolean f(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 != null && t2 != null)
            return t1.val == t2.val && f(t1.left,t2.right) && f(t1.right, t2.left);

        return false;
    }
}
