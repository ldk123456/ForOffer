import java.util.Scanner;

/**
 * 丑数
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(n));
    }

    /**
     * 首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，
     * 那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，
     * 换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到
     */
    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        int i2=0;
        int i3=0;
        int i5=0;
        int[] uglyNum=new int[index];
        uglyNum[0]=1;
        int count=0;
        while (count<index-1){
            int min=getMin(uglyNum[i2]*2, uglyNum[i3]*3, uglyNum[i5]*5);
            if (min==uglyNum[i2]*2)
                i2++;
            if (min==uglyNum[i3]*3)
                i3++;
            if (min==uglyNum[i5]*5)
                i5++;
            count++;
            uglyNum[count]=min;
        }
        return uglyNum[count];
    }
    public int getMin(int a, int b, int c){
        int min=a<b?a:b;
        min=min<c?min:c;
        return min;
    }
}
