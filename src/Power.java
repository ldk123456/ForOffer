import java.util.Scanner;

/**
 * 数值的整数次方
 */
public class Power {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double n=scanner.nextDouble();
        int m=scanner.nextInt();
        System.out.println(power(n, m));
    }

    /**
     * 1.全面考察指数的正负、底数是否为0等情况
     * 2.写出指数的二进制表达式，例如13表达为二进制1101
     * 3.举例：10^13=10^1101=10^0001*10^0100*10^1000
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果
     */
    public static double power(double base, int exponent){
       int n;
       double res=1, curr=base;

       if (exponent>0){
           n=exponent;
       }else if (exponent<0){
           if (base==0){
               throw new RuntimeException("分母不能为0");
           }
           n=-exponent;
       }else {
           return 1;
       }

       while (n!=0){
           if ((n&1)==1)
               res*=curr;
           curr*=curr;
           n>>=1;                //右移一位
       }

       if (exponent<0)
           res=1/res;

       return res;
    }
}
