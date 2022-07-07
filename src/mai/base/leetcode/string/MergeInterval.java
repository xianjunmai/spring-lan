package mai.base.leetcode.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * 合并区间
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] list = new int[][]{{1,3},{2,6},{7,9}};
        int[][] tag = doMergeInterval(list);
        System.out.println(tag);
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param intervals
     * @return
     */
    public static int[][] doMergeInterval(int[][] intervals){
        int start = 0;
        int end = 0;
        int[][] result = new int[][]{};
        for(int i=0;i<intervals.length;i++){
            int[] t = intervals[i];
            if(start == 0 && end == 0){
                start = t[0];
                end = t[1];
            }
            if(end>=t[0] && end<= t[1]){
                result[result.length] = new int[]{start,t[1]};
            }else{
                result[result.length] = new int[]{t[0],t[1]};
            }
        }
        return result;
    }

    public static int[][] doMergeInterval2(int[][] intervals){
        if (intervals.length == 1) {
            return intervals;
        }
        // 先给intervals按照每个元素的第一个数进行排序
        Arrays.sort(intervals, (int[] array1, int[] array2) -> {
            return array1[0] - array2[0];
        });
        Stack<int[]> res = new Stack<int[]>();
        // 将第一个加入栈
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = res.peek();
            // 如果栈顶元素下标为1的数大于或等于当前遍历到的下标0的数，则说明需要进行合并
            if (cur[1] >= intervals[i][0]) {
                // 合并时，右区间应该取最大值
                cur[1] = Math.max(intervals[i][1],cur[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        // 遍历栈，输出数组
        int[][] ints = new int[res.size()][2];
        for (int i = ints.length - 1; i >= 0; i--) {
            ints[i] = res.pop();
        }
        return ints;
    }
}
