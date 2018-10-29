/**
 * 数组中的逆序对
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,0};
        System.out.println(new InversePairs().InversePairs(array));
    }

    /**
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     * 数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     * 还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
     */
    public int InversePairs(int [] array) {
        if(array==null || array.length<=0){
            return 0;
        }
        int pairsNum=mergeSort(array,0,array.length-1);
        return pairsNum;
    }

    public int mergeSort(int[] array,int left,int right){
        if(left==right){
            return 0;
        }
        int mid=(left+right)/2;
        int leftNum=mergeSort(array,left,mid);
        int rightNum=mergeSort(array,mid+1,right);
        return (Sort(array,left,mid,right)+leftNum+rightNum)%1000000007;
    }

    public int Sort(int[] array,int left,int middle,int right){
        int current1=middle;
        int current2=right;
        int current3=right-left;
        int temp[]=new int[right-left+1];
        int pairsnum=0;
        while(current1>=left && current2>=middle+1){
            if(array[current1]>array[current2]){
                temp[current3--]=array[current1--];
                pairsnum+=(current2-middle);     //这个地方是current2-middle！！！！
                if(pairsnum>1000000007)//数值过大求余
                {
                    pairsnum%=1000000007;
                }
            }else{
                temp[current3--]=array[current2--];
            }
        }
        while(current1>=left){
            temp[current3--]=array[current1--];
        }
        while(current2>=middle+1){
            temp[current3--]=array[current2--];
        }
        //将临时数组赋值给原数组
        int i=0;
        while(left<=right){
            array[left++]=temp[i++];
        }
        return pairsnum;
    }
}
