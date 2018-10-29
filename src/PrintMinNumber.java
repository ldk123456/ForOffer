import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        PrintMinNumber p=new PrintMinNumber();
        int[] numbers={3,32,321};
        System.out.println(p.PrintMinNumber(numbers));
    }

    /**
     * 自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，
     * 比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面
     */
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1+""+o2;
                String s2=o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuffer sb=new StringBuffer();
        for (int i: list){
            sb.append(i);
        }
        return sb.toString();
    }
}
