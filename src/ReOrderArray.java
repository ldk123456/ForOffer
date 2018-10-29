/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 新建一个相同长度的数组，为0的下标
     * 第一遍遍历，遇到奇数就放入新数组中，下标+1
     * 第二遍遍历，遇到偶数就放入新数组中，下标+1
     */
    public static void reOrderArray(int[] array) {
        if(array == null || array.length == 0){
            return;
        }
        int[] temp=new int[array.length];
        int left=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2!=0){
                temp[left]=array[i];
                left++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                temp[left]=array[i];
                left++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=temp[i];
        }
    }
}
