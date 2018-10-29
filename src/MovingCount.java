/**
 * 机器人的运动范围
 */
public class MovingCount {
    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(10, 1, 100));
    }

    /**
     * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
     * 返回1 + 4 个方向的探索值之和。
     * 2.探索时，判断当前节点是否可达的标准为：
     * 1）当前节点在矩阵内；
     * 2）当前节点未被访问过；
     * 3）当前节点满足limit限制。
     */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] moved=new boolean[rows][cols];

        return move(threshold, rows, cols, 0, 0, moved);
    }
    public int move(int k, int rows, int cols, int i, int j, boolean[][] moved){
        if (i<0||i>=rows||j<0||j>=cols||addIndex(i)+addIndex(j)>k||moved[i][j])
            return 0;
        moved[i][j]=true;
        return  move(k, rows, cols, i+1, j, moved)
                +move(k, rows, cols, i-1, j, moved)
                +move(k, rows, cols, i, j+1, moved)
                +move(k, rows, cols, i, j-1, moved)+1;
    }
    public int addIndex(int i){
        int sum=0;
        while (i!=0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }
}
