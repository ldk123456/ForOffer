import java.util.Scanner;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(Fibonacci(n));
    }
    // 动态规划，记录每次运算的结果
    public static int Fibonacci(int n) {

        if(n<=1){
            return n;
        }

        int[] record = new int[n+1];
        record[0] = 0;
        record[1] = 1;
        for(int i=2;i<=n;i++){
            record[i] = record[i-1] + record[i-2];
        }
        return record[n];
    }
}
