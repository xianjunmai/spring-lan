package mai.base.leetcode.array;

/**
 * 旋转矩阵
 */
public class RotateMatrix {

    public static void main(String[] args) {

    }

    /**
     * Given matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * Rotate the matrix in place. It becomes:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/array-and-string/clpgd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *  对角线翻转
     *  [
     *    [1,4,7],
     *    [2,5,8],
     *    [3,6,9]
     *  ]
     *
     *  3:3 0,0  0,2 （3-0-1）
     *
     *  4:4 0,0  0,3（4-0-1）  0,1 0,2 （4-1-1）
     *  4:4 1,0  1,3（）
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int[][] result = matrix;
        for(int i=0;i<matrix.length;i++){
           // result[]
        }
    }

    public static void rotate2(int[][] matrix) {
        int temp = 0;
        //沿对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //镜像翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = temp;
            }
        }
    }
}
