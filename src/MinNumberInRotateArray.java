
/**
 * 旋转数组的最小数字
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] num={6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,
                9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,
                1870,1943,2383,2392,2996,3282,
                3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(num));
    }
    public static int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;
        // 遍历整个数组，找到最小值
        /*Arrays.sort(array);
        return array[0];*/

        //遍历数组，直到后一个数小于前一个数
        /*for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1])
                return array[i+1];
        }
        return array[0];*/

        //二分查找
        int left=0;
        int right=array.length-1;
        int mid=0;
        while (left<right){
            mid=(left+right)/2;
            if (array[left]==array[mid]){
                return array[mid+1];
            }else if (array[left]<array[mid]){
                left=mid;
            }else {
                right=mid;
            }
        }
        return 0;
    }
}
