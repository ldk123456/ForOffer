class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static void print(TreeNode root){
        if (root!=null){
            System.out.print(root.val+"  ");
            print(root.left);
            print(root.right);
        }
    }
}

public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        TreeNode treeNode=reConstructBinaryTree(preOrder, inOrder);
    }

    /**
     * 重建二叉树
     * 在二叉树的前序遍历序列中，第一个数字总是树的根节点的值。
     * 但在中序遍历中，根节点的值在序列的中间，左子树的结点的值位于根节点的值的左边，
     * 而右子树的结点的值位于根节点的右边。因此我们需要扫描中序遍历序列，才能找到根节点的值。
     */
    public static TreeNode reConstructBinaryTree(int[] pre,int[] in) {

        TreeNode root=reConstructBinaryTree(pre, 0, pre.length-1,
                in, 0, in.length-1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                                  int[] in, int startIn, int endIn) {

        if (startPre>endPre || startIn>endIn){
            return null;
        }

        TreeNode root=new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre, startPre+1, i-startIn+startPre,
                        in, startIn, i-1);
                root.right=reConstructBinaryTree(pre, i-startIn+startPre+1, endPre,
                        in, i+1, endIn);
            }
        }
        return root;
    }
}
