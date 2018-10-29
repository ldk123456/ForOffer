import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list=printMatrix(matrix);
        System.out.println(list);
    }

    /**
     * 设定左，上，右，下四个值定位需要打印的数据
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null || matrix.length==0)
            return null;

        ArrayList<Integer> list=new ArrayList<>();

        int left=0;                       //左
        int right=matrix[0].length-1;     //右
        int top=0;                        //上
        int bottom=matrix.length-1;       //下

        while (left<=right&&top<=bottom){ //判断矩阵还有数据
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]); //从左到右打印数据
            }
            top++;                        //去掉最上一行的数据
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]); //从上到下打印数据
            }
            right--;                      //去掉最右一列的数据
            if (top<=bottom){             //判断行数
                for (int i = right; i >=left ; i--) {
                    list.add(matrix[bottom][i]);  //从右到左打印数据
                }
                bottom--;                       //去掉最下一行的数据
            }
            if (left<=right){               //判断列数
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]); //从下到上打印数据
                }
                left++;                      //去掉最左一列的数据
            }
        }

        return list;
    }
}
