/**
 * 构建乘积数组
 */
public class Multiply {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b=new Multiply().multiply(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+"\t");
        }
    }
    public int[] multiply(int[] A) {
        /**
         * 两层循环，除去自己这项，其他项相乘
         */
        /*if (A==null || A.length==0)
            return null;
        int[] b=new int[A.length];
        for (int i = 0; i < b.length; i++) {
            int res=1;
            for (int j = 0; j < b.length; j++) {
                if (i==j)
                    continue;
                res*=A[j];
            }
            b[i]=res;
        }
        return b;*/

        /**
         * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
         * 从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
         * 从右到左算B[i]*=A[i+1]*...*A[n-1]
         */
        if (A==null || A.length==0)
            return null;
        int[] b=new int[A.length];
        b[0]=1;
        for (int i = 1; i < A.length; i++) {
            b[i]=b[i-1]*A[i-1];
        }
        int temp=1;
        for (int i = A.length-2; i >=0 ; i--) {
            temp*=A[i+1];
            b[i]*=temp;
        }
        return b;
    }
}
