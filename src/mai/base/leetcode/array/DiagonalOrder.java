package mai.base.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalOrder {

    public static void main(String[] args) {

    }

    /**
     *
     * [{1,2,3},
     * {4,5,6},
     * {7,8,9}]
     * [0,0] [0,1] [1,0] [2,0] [1,1] [0,2] [1,2] [2,1] [2,2]
     * @param mat
     * @return
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        // 对角线迭代+翻转
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m*n];
        int resIndex = 0;
        List<Integer> inner = new ArrayList<>();
        // 沿着第一行从左到右，到行尾处再沿着最后一列从上到下，每个元素作为遍历每个对角线的起点
        for(int i = 0; i < m + n -1; i++){
            inner.clear();
            int startR = i < n ? 0 : i - n + 1;
            int startC = i < n ? i : n - 1;
            // 遍历对角线
            while(startR < m && startC > -1){
                inner.add(mat[startR][startC]);
                startR++;
                startC--;
            }
            // 如果对角线是第偶数个，则需要翻转对角线遍历结果
            if((i % 2) == 0){
                Collections.reverse(inner);
            }
            // 将该对角线遍历结果添加到res
            for(int j = 0; j < inner.size(); j++){
                res[resIndex] = inner.get(j);
                resIndex++;
            }
        }
        return res;
    }
}
