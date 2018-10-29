/**
 * 不用加减乘除做加法
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(new Add().Add(5, 5));
    }

    /**
     *
     * step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果
     * step2:异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，
     *       结果表示非进位位进行加操作后的结果
     * step3:n1&n2是查看有没有进位位了，如果有，需要重复step1、step2；
     *       如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果
     */
    public int Add(int num1,int num2) {
        while (num2!=0){
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
}
