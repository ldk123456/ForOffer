import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的深度
 */
public class TreeDepth {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left=new TreeNode(4);
        System.out.println(new TreeDepth().TreeDepth(root));
    }
    public int TreeDepth(TreeNode root) {
        /**
         * 递归
         */
        if (root==null)
            return 0;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left, right)+1;

        /**
         * 利用层次遍历的算法，设置变量level记录当前结点所在的层数，
         * 设置变量last指向当前层的最后一个结点，当处理当前层的最后一个节点，让level+1，
         * 设置变量cur记录当前层已经访问结点个数，当cur等于last，表示该层访问结束。
         */
        /*if(root == null)
            return 0;

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur,last;
        int level = 0;
        while(!queue.isEmpty())
        {
            cur = 0;//记录本层已经遍历的节点个数
            last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            while(cur < last){//当还没有遍历到本层最后一个节点时循环
                current = queue.poll();//出队一个元素
                cur++;
                //把当前节点的左右节点入队（如果存在的话）
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;//每遍历完一层level+1
        }
        return level;*/

        /**
         * 利用非递归后序遍历求树的深度，在每次输出的时候改成求栈的大小，
         * 遍历结束后，栈的最大的大小就为树的深度。
         */
        /*Stack s=new Stack();
        TreeNode p=root;
        Stack<Integer> tag=new Stack<>();
        int max=0;
        while(p!=null||!s.isEmpty()){
            while(p!=null){
                s.push(p);
                tag.push(0);
                p=p.left;
            }
            if(tag.peek()==1){
                max=max>s.size()?max:s.size();
                s.pop();
                tag.pop();
                p=null;
            }else{
                p=(TreeNode) s.peek();
                p=p.right;
                tag.pop();
                tag.push(1);
            }
        }
        return max;*/
    }
}
