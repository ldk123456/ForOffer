import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 */
public class FindPath {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists=FindPath(root, 9);
        System.out.println(lists);
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        if(root == null || root.val > target)
            return pathlist;
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPath(root,target,pathlist,path);
        return pathlist;
    }
    private static void findPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> pathlist,ArrayList<Integer> path)
    {
        //如果节点为空，或者值大于target此条路径清空
        if(root == null || root.val > target) {
            path.clear();
        }
        else if(root.val == target)//如果当前节点等于target且为叶子节点则直接将它添加到path中，否则这条路径清空
        {
            if(root.left == null && root.right==null)
            {
                path.add(root.val);
                pathlist.add(path);
            }
            else
            {
                path.clear();
            }
        }
        else  //当根节点的值小于target，则递归去寻找它的左右子树
        {
            path.add(root.val);
            ArrayList<Integer> path2 = new ArrayList<Integer>();
            path2.addAll(path);
            target -= root.val;
            findPath(root.left,target,pathlist,path);
            findPath(root.right,target,pathlist,path2);
        }
    }
}
