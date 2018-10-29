import java.util.HashMap;
import java.util.Map;

/**
 * 数组中只出现一次的数字
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] array={1,6,8,4,3,5,9,7,2,1,6,8,4,3,7,2};
        int[] num1=new int[1];
        int[] num2=new int[1];
        new FindNumsAppearOnce().FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]+"   "+num2[0]);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        /**
         * 使用HashMap
         */
        /*if (array.length==0 && array.length==1)
            return;
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                int count=map.get(array[i])+1;
                map.put(array[i], count);
            }else {
                map.put(array[i], 1);
            }
        }
        int[] res=new int[2];
        int j=0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])==1){
                if (j<res.length){
                    res[j]=array[i];
                    j++;
                }
            }
        }
        num1[0]=res[0];
        num2[0]=res[1];*/

        /**
         * 首先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
         * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
         * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
         * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
         */

        int len=array.length;
        if (len==2){
            num1[0]=array[0];
            num2[0]=array[1];
            return;
        }

        int bitRes=0;
        for (int i = 0; i < len; i++) {
            bitRes^=array[i];
        }

        int index=first1(bitRes);
        for (int i = 0; i < len; i++) {
            if (isBit1(array[i], index)){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }
    public int first1(int bitRes){
        int index=0;
        while ((bitRes&1)==0&&index<32){
            bitRes>>=1;
            index++;
        }
        return index;
    }
    public boolean isBit1(int temp, int index){
        return (temp>>index&1)==1;
    }
}
