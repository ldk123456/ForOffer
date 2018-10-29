
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 */
public class PrintOfLevel {
    /**
     * 队列完成层序遍历，用end记录每层结点数目
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new ArrayDeque<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        return result;
    }
}
