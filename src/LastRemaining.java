import java.util.ArrayList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution(10, 3));
    }
    public int LastRemaining_Solution(int n, int m) {

        /**
         * 数组模拟环，每次删除时注意下标的变化
         */
        if (n==0||m==0)
            return -1;
        ArrayList<Integer> data=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = 0;
        while (data.size() > 1) {
            index = (index + m-1) % data.size();
            data.remove(index);
        }
        return data.get(0);

        /**
         * 约瑟夫环
         */
        /*if(n < 1 || m < 1)
            return -1;
        if(n == 1){
            return 0;
        }
        return (LastRemaining_Solution(n-1, m)+m)%n;*/
    }
}
