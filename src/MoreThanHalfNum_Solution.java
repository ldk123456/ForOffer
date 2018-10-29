import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        MoreThanHalfNum_Solution solution=new MoreThanHalfNum_Solution();
        int[] array={1,2,3,2,4,2,5,2,3};
        System.out.println(solution.MoreThanHalfNum_Solution(array));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null || array.length==0)
            return 0;

        //先排序，如果存在肯定就是中间的那个数 O(nlogn)
        /*Arrays.sort(array);
        int mid=array[array.length/2];
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==mid){
                count++;
                if (count>array.length/2)
                    return mid;
            }
        }
        return 0;*/

        //用HashMap    O(n)
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else {
                int count=map.get(array[i])+1;
                map.put(array[i], count);
            }
        }
        Iterator iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry= (Map.Entry) iterator.next();
            Integer key= (Integer) entry.getKey();
            Integer value= (Integer) entry.getValue();
            if (value> array.length/2)
                return key;
        }
        return 0;
    }
}
