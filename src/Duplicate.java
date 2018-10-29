import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] numbers={2,3,1,0,2,5,3};
        int length=numbers.length;
        int[] duplication=new int[1];
        if (new Duplicate().duplicate(numbers, length, duplication))
            System.out.println(duplication[0]);
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        /**
         * map遍历
         */
        /*if (length==0)
            return false;
        if (length==1){
            duplication[0]=numbers[0];
            return true;
        }
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])){
                int num=map.get(numbers[i])+1;
                map.put(numbers[i], num);
            }else {
                map.put(numbers[i], 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (map.get(numbers[i])!=1){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;*/

        /**
         * 每次检查，第一次设true
         */
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
