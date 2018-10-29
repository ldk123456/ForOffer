public class Find {
    public static void main(String[] args) {
        int[][] num={{1,3,5,7},{2,8,11,14},{4,9,12,15},{6,10,13,16}};
        System.out.println(find(20, num));
    }

    /**
     * 二维数组中的查找
     * 选择该二维数组的最右上角的那个数开始扫描，
     * 当target小于该值时，可以清除一列，当target大于该值时，可以清除一行
     */
    public static boolean find(int target, int [][] array) {
        if (array==null){
            return false;
        }

        int row=0;//第一行
        int list=array[0].length-1;//最后一列
        int len=array.length;

        while (row<len&&list>=0){
            int temp=array[row][list];//与右上角的元素比较
            if (target>temp){
                row++;
            }else if (target<temp){
                list--;
            }else {
                return true;
            }
        }

        return false;
    }
}
