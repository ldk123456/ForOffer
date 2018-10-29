/**
 * 连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        FindGreatestSumOfSubArray f=new FindGreatestSumOfSubArray();
        int[] array={6,-3,-2,7,-15,1,2,2};
        System.out.println(f.FindGreatestSumOfSubArray(array));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0)
            return 0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum<0){
                sum=array[i];
            }else {
                sum+=array[i];
            }
            if (sum>max)
                max=sum;
        }
        return max;
    }
}
