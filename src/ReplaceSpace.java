public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer buffer=new StringBuffer("Hello World !");
        System.out.println(replaceSpace(buffer));
    }
    // 替换空格
    public static String replaceSpace(StringBuffer str) {
        /**
         * 简单的写法，但时间复杂度高
         */
        /*return str.toString().replaceAll(" ", "%20");*/

        /**
         * 我的写法
         */
        for(int k=0; k<str.length(); k++)
        {
            char index = str.charAt(k);
            if(index == ' ')
            {
                str.replace(k, k+1, "%20");  //这里用的巧妙，不用考虑变换后长度问题。
            }
        }

        return str.toString();

        /**
         * 我们先遍历一次字符串，这样就能够统计出字符串中空格的综述，并可以计算出替换之后字符串的总的长度。
         * 每替换一个空格，长度增加2，因此替换以后的字符串的长度等于原来的长度加上2乘以空格的数目.
         * 我们从字符串的后面开始复制和替换。首先准备两个指针，P1和P2.
         * P1指向原始字符串的末尾，而P2指向替换之后的字符串的末尾。
         * 接下来我们向前移动指针P1,逐个把它指向的字符复制到P2指向的位置，直到碰到第一个空格为止，
         * 把P1向前移动一格，在P2之前插入字符串”%20“，由于”%20“的长度为3，同时也要把P2向前移动3格如图所示。
         * P1，P2指向同一个位置，表明所有的空格都已经替换完毕。
         */
        /*int originalLength = str.length()-1;  //字符串str原长度
        int numberOfBlank = 0;   //空格的个数
        //int i = 0;
        for(char c : str.toString().toCharArray()){
            if (c == ' '){
                numberOfBlank++;
            }
        }
        int newLength = originalLength + numberOfBlank*2+1;
        str.setLength(newLength);
        newLength = newLength-1;
        while (originalLength >= 0 && newLength > originalLength){
            if (str.charAt(originalLength) == ' '){
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }else{
                str.setCharAt(newLength--,str.charAt(originalLength));
            }
            originalLength--;
        }
        return str.toString();*/
    }
}
