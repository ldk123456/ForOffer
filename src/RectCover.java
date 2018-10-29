import java.util.Scanner;

/**
 * 矩形覆盖
 */
public class RectCover {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(rectCover(n));
    }
    //动态规划： 斐波那契数列
    public static int rectCover(int target) {
        if(target<=2)
            return target;
        int[] result=new int[target+1];
        result[1]=1;
        result[2]=2;
        for (int i = 3; i < result.length; i++) {
            result[i]=result[i-1]+result[i-2];
        }
        return result[target];
    }
}
