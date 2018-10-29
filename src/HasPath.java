/**
 * 矩阵中的路径
 */
public class HasPath {
    public static void main(String[] args) {
        char[] matrix={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str={'b','c','c','e','d'};
        System.out.println(new HasPath().hasPath(matrix, 3, 4, str));
    }

    /**
     * 1.将matrix字符串模拟映射为一个字符矩阵(但并不实际创建一个矩阵)
     * 2.取一个boolean[matrix.length]标记某个字符是否已经被访问过。
     * 3.如果没找到结果，需要将对应的boolean标记值置回false,返回上一层进行其他分路的查找。
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited=new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchFromHere(matrix, rows, cols, i, j, 0, str, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean searchFromHere(char[] matrix, int rows, int cols,
                                  int i, int j, int index, char[] str, boolean[] visited){
        int t=i*cols+j;
        if (i<0 || i>=rows || j<0 || j>=cols || matrix[t]!=str[index] || visited[t]){
            return false;
        }
        if (index==str.length-1)
            return true;
        visited[t] = true;
        if (searchFromHere(matrix, rows, cols, i-1, j, index+1, str, visited)
                || searchFromHere(matrix, rows, cols, i+1, j, index+1, str, visited)
                || searchFromHere(matrix, rows, cols, i, j-1, index+1, str, visited)
                || searchFromHere(matrix, rows, cols, i, j+1, index+1, str, visited))
            return true;
        visited[t]=false;
        return false;
    }
}
