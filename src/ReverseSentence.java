/**
 * 翻转单词顺序列
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence("student. a am I"));
    }
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] res=str.split(" ");
        StringBuffer sb=new StringBuffer();
        for (int i = res.length-1; i >= 0; i--) {
            sb.append(res[i]);
            if (i>0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
