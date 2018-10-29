/**
 * 树的子结构
 */
public class HasSubtree {
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(8);
        root1.left=new TreeNode(6);
        root1.right=new TreeNode(10);
        root1.left.left=new TreeNode(5);
        root1.left.right=new TreeNode(7);
        root1.right.left=new TreeNode(9);
        root1.right.right=new TreeNode(11);
        TreeNode root2=new TreeNode(6);
        root2.left=new TreeNode(5);
        root2.right=new TreeNode(7);
        System.out.println(hasSubtree(root1, root2));
    }
    public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = hasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = hasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }
    public static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2==null)
            return true;
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1==null)
            return false;
        //如果其中有一个点没有对应上，返回false
        if (root1.val!=root2.val)
            return false;

        //如果根节点对应的上，那么就分别去左右子节点里面匹配
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
