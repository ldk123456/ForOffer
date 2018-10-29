import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().FindContinuousSequence(100));
    }

    /**
     * 初始化small=1，big=2;
     * small到big序列和小于sum，big++;大于sum，small++;
     * 当small增加到sum/2时停止
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(sum < 3) {
            return list; //因为至少要包括两个数，要求的是正整数序列，那么最小的和为3
        }
        int small = 1;//用来记录正整数序列中最小的数，
        int big = 2;//用来记录正整数序列中最大的数
        int mid = sum /2;//序列之和为sum的数至少包括两个数，所以small<mid
        int curSum = small + big;//当前序列总和
        while(small <= mid) {
            //当前的序列和大于sum
            while(curSum > sum && small <= mid) {
                curSum = curSum-small;
                small++;
            }
            //当前序列和为sum了，则将这些数加入到list中
            if(curSum == sum) {
                ArrayList<Integer> listSum = new ArrayList<Integer>();
                add(listSum,small,big);
                list.add(listSum);
            }
            //当前的序列和小于sum
            big++;
            curSum = curSum+big;

        }
        return list;

    }
    private static void add(ArrayList<Integer> list,int small,int big) {
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
    }
}
