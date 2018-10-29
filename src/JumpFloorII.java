import java.util.Scanner;

/**
 * 变态跳台阶
 */
public class JumpFloorII {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(jumpFloorII(n));
    }
    //f(n)=f(n-1)+f(n-2)+...+f(1)+1=2*f(n-1)
    public static int jumpFloorII(int target){

        //递归
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        int sum=0;
        for (int i = 1; i < target; i++) {
            sum+=jumpFloorII(i);
        }
        return sum+1;

        //非递归
        /*int sum=1;
        while (target>1){
            sum*=2;
            target--;
        }
        return sum;*/
    }
}
