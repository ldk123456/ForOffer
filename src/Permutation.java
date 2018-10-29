import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 字符串的排列
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation p=new Permutation();
        System.out.println(p.Permutation("abc"));
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        findPermutation(res, chs, 0);
        //排序
        Collections.sort(res);
        return res;
    }

    //对cha[i~length-1]范围内的字符数组完成全排列，并将结果加入res中
    public void findPermutation(ArrayList<String> res, char[] chs, int i) {
        //基本情况
        if (i == chs.length) {
            res.add(new String(chs));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        //从【i~length-1】中枚举确定i位置的字符
        for (int j = i; j < chs.length; j++) {
            //如果以前未被选过
            if (! set.contains(chs[j])) {
                set.add(chs[j]);
                //交换
                swap(chs, i, j);
                //确定好i位置，对cha[i+1~length-1]范围内的字符数组完成全排列
                findPermutation(res, chs, i + 1);
                //恢复原数组
                swap(chs, i, j);
            }
        }
        return;
    }
    public void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
