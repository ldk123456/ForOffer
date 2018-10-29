/**
 * 把字符串转换成整数
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("123"));
    }
    public int StrToInt(String str) {
        if (str==null ||str.length()==0)
            return 0;
        int res=0;
        int flag=0;
        str.trim();
        if (str.charAt(0)=='+'){
            flag=1;
        }else if (str.charAt(0)=='-'){
            flag=-1;
        }else {
            char c=str.charAt(0);
            if (c<'0'||c>'9')
                return 0;
        }
        for (int i = Math.abs(flag); i < str.length(); i++) {
            char c=str.charAt(i);
            if (c<'0'||c>'9')
                return 0;
            res=res*10+c-'0';
        }
        if (flag==0)
            return res;
        return res*flag;
    }
}
