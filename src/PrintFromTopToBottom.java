import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 */
public class PrintFromTopToBottom {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(6);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(11);
        System.out.println(PrintFromTopToBottom(root));
    }

    /**
     * 层次遍历
     * 借助队列，将根节点入队
     * 每次出队，检查出队的节点是否有左右子节点，有就入队
     * 循环直到队列为空
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if (root==null)
            return list;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            list.add(treeNode.val);
            if (treeNode.left!=null)
                queue.offer(treeNode.left);
            if (treeNode.right!=null)
                queue.offer(treeNode.right);
        }
        return list;
    }
}
