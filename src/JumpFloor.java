import java.util.Scanner;

/**
 * 跳台阶
 */
public class JumpFloor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(jumpFloor(n));
    }
    //动态规划：f(n)=f(n-1)+f(n-2)
    public static int jumpFloor(int target) {
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        int[] count=new int[target+1];
        count[1]=1;
        count[2]=2;
        for (int i = 3; i < count.length; i++) {
            count[i]=count[i-1]+count[i-2];
        }
        return count[target];
    }
}
