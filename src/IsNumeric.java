/**
 * 表示数值的字符串
 */
public class IsNumeric {
    public static void main(String[] args) {
        String s="1.2.3";
        char[] chars=s.toCharArray();
        System.out.println(new IsNumeric().isNumeric(chars));
    }
    public boolean isNumeric(char[] str) {
        if (str==null || str.length==0)
            return false;
        // 标记符号、e、小数点是否出现过
        boolean sign=false;
        boolean e=false;
        boolean decimal=false;
        for (int i = 0; i < str.length; i++) {
            if (str[i]=='e' || str[i]=='E'){
                if (e) // 不能同时存在两个e
                    return false;
                if (i==str.length-1) // e后面一定要接数字
                    return false;
                e=true;
            }else if (str[i]=='+' || str[i]=='-'){
                if (sign && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;  // 第二次出现+/-符号，则必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;   // 第一次出现+/-符号，且不是在字符串开头，则也必须紧接在e之后
                sign = true;
            }else if (str[i] == '.'){
                if (e || decimal)
                    return false;   // e后面不能接小数点，小数点不能出现两次
                decimal=true;
            }else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }
}
