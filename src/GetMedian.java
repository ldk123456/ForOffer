
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class GetMedian {

    /**
     * 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
     * 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
     * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
     */
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 判断偶数的高效写法
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count==0)
            throw new RuntimeException("no available number!");
        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if((count&1)==1)
            result=maxHeap.peek();
        else
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }
}
