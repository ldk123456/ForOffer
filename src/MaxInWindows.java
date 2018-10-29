import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] num={2,3,4,2,6,2,5,1};
        int size=3;
        System.out.println(new MaxInWindows().maxInWindows(num, size));
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        /**
         * 最直接的算法，每次滑动窗口数组找到最大值
         */
        /*ArrayList<Integer> list=new ArrayList<>();
        if (num.length==0 || size==0)
            return list;
        for (int i = 0; i <= num.length-size; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < size; j++) {
                if (num[i+j]>max)
                    max=num[i+j];
            }
            list.add(max);
        }
        return list;*/

        /**
         * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
         * 1.判断当前最大值是否过期
         * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
         */
        ArrayList<Integer> list=new ArrayList<>();
        if (num.length==0 || size==0)
            return list;
        int begin;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin=i-size+1;
            if (q.isEmpty())
                q.add(i);
            else if (begin>q.peekFirst())
                q.pollFirst();
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if(begin >= 0)
                list.add(num[q.peekFirst()]);
        }
        return list;
    }
}
