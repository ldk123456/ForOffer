/**
 * 平衡二叉树
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left=new TreeNode(4);
        System.out.println(new IsBalanced().IsBalanced_Solution(root));
    }

    public boolean isBalanced=true;

    public boolean IsBalanced_Solution(TreeNode root) {
        /**
         * 递归
         */
        /*if (root==null)
            return true;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.abs(left-right)<=1&&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);*/

        /**
         * 后续遍历时，遍历到一个节点，其左右子树已经遍历
         * 依次自底向上判断，每个节点只需要遍历一次
         */
        getDepth(root);
        return isBalanced;
    }

    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left, right)+1;
    }

    public int getDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return Math.max(left, right)+1;
    }
}
