/**
 * 二叉树的镜像
 */
public class Mirror {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(6);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(11);
        TreeNode.print(root);
        System.out.println();
        mirror(root);
        TreeNode.print(root);
    }

    /**
     * root若不为空，交换左右节点
     * 递归左子树和右子树
     * @param root
     */
    public static void mirror(TreeNode root) {
        if (root==null)
            return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if (root.left!=null)
            mirror(root.left);
        if (root.right!=null)
            mirror(root.right);
    }
}
