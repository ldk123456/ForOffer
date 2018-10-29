/**
 * 二叉搜索树的后序遍历序列
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] order={2,5,4,9,7};
        System.out.println(VerifySquenceOfBST(order));
    }

    /**
     * 左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
     * 最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
     * 即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理
     *  
     * 对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
     * 只需看看右子树的右子树是否符合要求即可
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0)
            return false;
        if (sequence.length==1)
            return true;

        int len=sequence.length;
        int i=0;

        while (--len!=0){
            while (sequence[i]<sequence[len])
                i++;
            while (sequence[i]>sequence[len])
                i++;
            if (i<len)
                return false;
            i=0;
        }

        return true;
    }
}
