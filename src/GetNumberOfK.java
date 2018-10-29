/**
 * 数字在排序数组中出现的次数
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,5,5,6,7,8,9};
        System.out.println(new GetNumberOfK().GetNumberOfK(array, 5));
    }
    public int GetNumberOfK(int [] array , int k) {
        /**
         * 遍历整个数组
         */
        /*int count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==k)
                count++;
        }
        return count;*/

        /**
         * 二分查找，找到第一个k和最后一个k，相减
         */
        int firstK=getFirst(array, k);
        int lastK=getLast(array, k);
        return lastK-firstK+1;
    }
    public int getFirst(int[] array, int k){
        int start=0, end=array.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (array[mid]<k)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }
    public int getLast(int[] array, int k){
        int start=0, end=array.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (array[mid]<=k)
                start=mid+1;
            else
                end=mid-1;
        }
        return end;
    }
}
