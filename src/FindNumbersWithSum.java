import java.util.ArrayList;

/**
 * 和为S的两个数字
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9};
        System.out.println(new FindNumbersWithSum().FindNumbersWithSum(array, 9));
    }

    /**
     * 数列满足递增，设两个头尾两个指针i和j，
     * 若ai + aj == sum，就是答案（相差越远乘积越小）
     * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j --
     * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i ++
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result=new ArrayList<>();
        int start=0;
        int end=array.length-1;
        while (start<end){
            if (array[start]+array[end]==sum){
                result.add(array[start]);
                result.add(array[end]);
                return result;
            }
            while (array[start]+array[end]<sum&&start<end)
                start++;
            while (array[start]+array[end]>sum&&start<end)
                end--;
        }
        return result;
    }
}
