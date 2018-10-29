/**
 * 字符流中第一个不重复的字符
 */
public class FirstAppearingOnce {
    int[] hashtable=new int[256];
    StringBuffer s=new StringBuffer();
    //从串流插入一个字符
    public void Insert(char ch) {
        s.append(ch);
        if(hashtable[ch]==0)
            hashtable[ch]=1;
        else hashtable[ch]+=1;
    }
    //返回当前字符串中的第一次出现字符
    public char FirstAppearingOnce() {
        char[] str=s.toString().toCharArray();
        for(char c:str) {
            if(hashtable[c]==1)
                return c;
        }
        return '#';
    }
}
