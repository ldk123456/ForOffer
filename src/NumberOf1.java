import java.util.Scanner;

/**
 * 二进制中1的个数
 */
public class NumberOf1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(numberOf1(n));
    }
    //n&(n-1)可以消除最后一个1
    public static int numberOf1(int n) {
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
