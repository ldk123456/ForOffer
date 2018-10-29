import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最小的K个数
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        GetLeastNumbers g=new GetLeastNumbers();
        int[] array={4,5,1,6,2,7,3,8};
        System.out.println(g.GetLeastNumbers_Solution(array, 4));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if (k==0||input.length==0||input==null||k>input.length)
            return result;
        //先排序，然后输出    O(nlogn)
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
}
