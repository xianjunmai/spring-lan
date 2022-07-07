package mai.base.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
    public static void main(String[] args) {

    }

    /**
     * 先遍历获取0元素的坐标 之后循环0元素置零
     *
     * 输入：
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出：
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * 若：[1,1] 为0 则 [0,1] [2,1]  [1,0] [1,2]
     * @param matrix
     */
    public static void doZeroMatrix(int[][] matrix){
        int xN = matrix.length;
        int yN = matrix[0].length;
        List<int[]> zeroList = new ArrayList<>();
        for(int x=0; x<xN;x++){
            for(int y=0;y<yN;y++){
                if(matrix[x][y]==0){
                    int[] zero = new int[]{x,y};
                    zeroList.add(zero);
                }
            }
        }
        for(int[] i : zeroList){
            for(int j=0;j<xN;j++){
                matrix[j][i[1]] = 0;
            }
            for(int k=0;k<yN;k++){
                matrix[i[0]][k] = 0;
            }
        }
    }
}
