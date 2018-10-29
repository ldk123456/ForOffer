import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 第一个只出现一次的字符
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar(s));
    }

    /**
     * 用图存下每个字符出现的次数
     * 遍历数组，第一个value为1的输出i
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.length()==0)
            return -1;
        Map<Character, Integer> map=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (map.containsKey(c)){
                int count=map.get(c)+1;
                map.put(c, count);
            }else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (map.get(c)==1)
                return i;
        }
        return -1;
    }
}
