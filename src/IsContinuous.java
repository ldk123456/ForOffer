import java.util.Arrays;

/**
 * 扑克牌顺子
 */
public class IsContinuous {
    /**
     * 1、排序
     * 2、计算所有相邻数字间隔总数
     * 3、计算0的个数
     * 4、如果2、3相等，就是顺子
     * 5、如果出现对子，则不是顺子
     */
    public boolean isContinuous(int [] numbers) {
        int length=numbers.length;
        if (length==0)
            return false;
        Arrays.sort(numbers);
        int numOfZero=0;
        int num=0;
        for (int i = 0; i < length-1; i++) {
            if (numbers[i]==numbers[i+1])
                return false;
            if (numbers[i]==0){
                numOfZero++;
                continue;
            }
            num+=numbers[i+1]-numbers[i]-1;
        }
        if (numOfZero>=num)
            return true;
        return false;
    }
}
